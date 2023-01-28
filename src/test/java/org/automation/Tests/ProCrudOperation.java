package org.automation.Tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ProCrudOperation {

//    @Test
    public void crudTests() {
        RestAssured.given()
                .baseUri("http://localhost:3000/")
                .basePath("persons").
                log()
                .all().
                when().
                get()
                //validate the Response   below code
                .then()
                //log the response after Hit the  End point
                .log()
                .all().statusCode(200);
    }

    @Test
    public void getBooking(){
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/{id}").pathParams("id",10179).
                log()
                .all().
                when().
                get()
                //validate the Response   below code
                .then()
                //log the response after Hit the  End point
                .log()
                .all().statusCode(200);
    }
}
