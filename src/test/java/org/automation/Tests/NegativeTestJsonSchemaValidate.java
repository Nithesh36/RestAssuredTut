package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class NegativeTestJsonSchemaValidate {
 static    String negativeUserData="{\n" +
            "    \"data\": {\n" +
            "        \"id\": 3,\n" +
            "        \"email\": \"emma.wong@reqres.in\",\n" +
            "        \"first_name\": \"Emma\",\n" +
            "        \"last_name\": \"Wong\",\n" +
            "        \"avatar\": \"https://reqres.in/img/faces/3-image.jpg\"\n" +
            "    },\n" +
            "    \"support\": {\n" +
            "        \"url\": \"https://reqres.in/#support-heading\",\n" +
            "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
            "    }\n" +
            "}";
    @Test(description = "negative scenario")
    public void validateJSONSchemaInternalJsonAndHamcrest(){
        String userSchemaIncorrectIdType=System.getProperty("user.dir")+"/src/main/resources/NegativeSchemaUsers.json";
        //base URL
        RestAssured.baseURI = "https://reqres.in/api/users/3";

        //obtain response
        given()
                .when().get();

        //verify JSON Schema
        MatcherAssert.assertThat(negativeUserData,JsonSchemaValidator.matchesJsonSchema(new File(userSchemaIncorrectIdType)));
        //MatcherAssert.assertThat(users,JsonSchemaValidator.matchesJsonSchema(new File(userSchema)));


    }

}
