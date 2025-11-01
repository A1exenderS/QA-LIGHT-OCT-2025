package org.qa.light.session9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

//TODO: add location to request
//TODO: Validate that street number and name are not null for 1st person generated

public class RestTests {

    @Test
    public void restTests() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc", "gender,name,nat");
        requestSpecification.queryParam("results", "3");
        requestSpecification.queryParam("noinfo");
        requestSpecification.header("Accept", "application/json");
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");

        Response response = requestSpecification.get();
        response.prettyPrint();
        String personGender = response.jsonPath().getString("results[0].gender");
        System.out.println("Gender: " + personGender);
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.contentType(ContentType.JSON);
        validatableResponse.statusCode(200);
        validatableResponse.body("results[0].gender",
                Matchers.equalTo("female"));
    }

    @Test
    public void restTests2() {
        ValidatableResponse r = RestAssured.given()
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", "3")
                .queryParam("noinfo")
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results.gender", Matchers.hasItem("female"));
    }
}
