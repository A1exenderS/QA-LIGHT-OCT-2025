package org.qa.light.session11;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.qa.light.session10.PersonDto;
import org.qa.light.session10.ResponseDto;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

//TODO: Use session 8 code as is, and make it save
// DeviceName, DevicePrice and DeviceScreenSize to DB

public class SqlTests {

    private Connection conn;
    private Statement stmt;

    @BeforeSuite
    public void setUp() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "user", "password");
        stmt = conn.createStatement();
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        conn.close();
    }

    @Test
    public void testSqlRead() throws SQLException {
        ResultSet resultSet = stmt.executeQuery("select * from Persons");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FirstName") +
                    " " + resultSet.getString("LastName"));
        }
    }

    @Test
    public void testSqlWrite() throws SQLException {
        ResponseDto responseDto = getRandomPeople(5);
        List<PersonDto> personDtos = responseDto.getResults();
        PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES (?,?,?,?,?)"
        );

        for (PersonDto personDto : personDtos) {
            preparedStatement.setString(1, personDto.getName().getFirst());
            preparedStatement.setString(2, personDto.getName().getLast());
            preparedStatement.setString(3, personDto.getGender());
            preparedStatement.setString(4, personDto.getName().getTitle());
            preparedStatement.setString(5, personDto.getNat());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to save in DB: " + personDto);
            }
        }
    }

    @Test
    public void testSqlReadParametrized() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "select FirstName as 'FN', LastName as 'LN' from Persons WHERE Nat = ?");
        stmt.setString(1, "UK");
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) +
                    " " + resultSet.getString(2));
        }
    }

    @Test
    public void testSqlReadRandom() throws SQLException {
        ResultSet resultSet = stmt.executeQuery(
                "select * from Persons ORDER BY RAND() LIMIT 1");
        if (resultSet.next()) {
            System.out.println(resultSet.getString("FirstName") +
                    " " + resultSet.getString("LastName"));
        }
    }

    private ResponseDto getRandomPeople(int amount) {
        return RestAssured.given()
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", amount)
                .queryParam("noinfo")
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .get()
                .prettyPeek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(ResponseDto.class);
    }
}
