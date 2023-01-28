package org.automation.Tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ExtractResponseBodyAsString {

    @Test
    public  void ExtractResponseInString(){
       String responseString= RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/{id}").pathParams("id",2).
                log()
                .all().
                when().
                get()
                //validate the Response   below code
                .then()
                //log the response after Hit the  End point
                .extract().body().asPrettyString();

       System.out.println("Response as String:"+ Arrays.toString(responseString.split(",")));

    }
}
