package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class CreateAuthToken {

    @Test
    public void createToken(){
       // https://restful-booker.herokuapp.com/auth
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("auth").
                contentType(ContentType.JSON).
        body("{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}").
                log()
                .all().
                when().
            post()
                //validate the Response   below code
                .then()
                //log the response after Hit the  End point
                .log()
                .all().statusCode(200);
    }
}
