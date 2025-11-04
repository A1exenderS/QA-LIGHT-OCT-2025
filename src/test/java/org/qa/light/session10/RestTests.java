package org.qa.light.session10;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasItem;

//TODO: Write Location DTO and make same assertions using DTO

public class RestTests {

    @Test
    public void restTests3() {
        ValidatableResponse r = RestAssured.given()
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", "3")
                .queryParam("noinfo")
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .get()
                .prettyPeek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results.findAll { it.gender == 'female' }.name.title", hasItem("Miss"));
    }

    @Test
    public void restTests4() {
        ResponseDto responseDto = RestAssured.given()
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", "100")
                .queryParam("noinfo")
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(ResponseDto.class);
//        System.out.println(responseDto.getResults().size());
//
//        List<PersonDto> results = responseDto.getResults();
//        results.stream()
//                .filter(p -> p.getNat().equals("UA"))
//                .filter(p -> p.getGender().equals("female"))
//                .map(p -> p.getName().getFirst() + " " + p.getName().getLast())
//                .forEach(firstlastName -> System.out.println(firstlastName));

//        List<String> firstLastName = responseDto.getResults()
//                .stream()
//                .map(p -> p.getName().getFirst() + " " + p.getName().getLast())
//                .toList();
//        System.out.println(firstLastName.size());

    }

    @Test
    public void restTests5() {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        strings.add("g");
        strings.add("h");
        strings.add("i");
        strings.add("j");
        String s = strings.stream().collect(Collectors.joining(","));
        System.out.println(s);
    }

    @Test
    public void restTestsLocation() {
        ResponseDto responseDto = RestAssured.given()
                .queryParam("inc", "gender,name,nat,location")
                .queryParam("results", "100")
                .queryParam("noinfo")
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(ResponseDto.class);

        List<PersonDto> results = responseDto.getResults();
        Assert.assertNotNull(results.get(0).getLocation().getStreet().getNumber(), "Number is not exist");
        Assert.assertNotNull(results.get(0).getLocation().getStreet().getName(), "Name is not exist");
    }
}
