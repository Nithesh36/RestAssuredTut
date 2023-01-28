package org.automation.Tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Objects;

public class PathParams {

    @Test
    public void PathParamEx(){
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("{basePath}/{id}").pathParams(Map.of("basePath","booking","id",3889)).
                log()
                .all().
                when().
                get()
                //validate the Response   below code
                .then()
                //log the response after Hit the  End point
                .log().all().statusCode(200);
    }
    @Test
    public void PathParamUsedInGetCall(){
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("{basePath}/{bookingId}")
                .when()
                //2nd argument will  map  based on index Booking will replace basePath vise versa
                .get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}","booking",3889)
                .then()
                .log()
                .all();
    }
}
