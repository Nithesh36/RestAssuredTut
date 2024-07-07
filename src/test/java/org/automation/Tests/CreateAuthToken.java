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

//        body("{\n" +
//                "    \"username\" : \"admin\",\n" +
//                "    \"password\" : \"password123\"\n" +
//                "}").

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
    @Test
    public  void basicAuth(){
        RestAssured.given().auth().basic("postman","password")
                .get("https://postman-echo.com/basic-auth").then().log().body();
        RestAssured.given().header("app","mob").when().get("");//api key
        RestAssured.given().header("Authorization","Bearer value(token)").when().get("");//api key
        RestAssured.given().auth().oauth2("").when().get("");

    }
}
