package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PathParams {

    /**
     * Base URL can't be parameterized  unlike Base Paths
     * Don't mix Path Params  By overriding the get Method
     */
    @Test
    public void PathParamUsingMap() {
        Map<String, Object> pathParameters = new HashMap<>();
        pathParameters.put("basePath", "booking");
        pathParameters.put("bookingId", 2); //we can create Map Object like above when we have multiple paths
        //needs to be parametrized
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("{basePath}/{id}").pathParams(Map.of("basePath", "booking", "id", 3889)).
                log()
                .all().
                when().
                get()
                //validate the Response   below code
                .then()
                //log the response after Hit the  End point
                .log().all().statusCode(200);

        //date validate
    }

    @Test
    public void PathParamUsedInGetCall() {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("{basePath}/{bookingId}")
                .when()
                //2nd argument will  map  based on index Booking will replace basePath vise versa
                .get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}", "booking", 3889)
                ;
    }

    @Test
    public void PathParamWithDroppingOnePathInBasePath() {
//        Response response = RestAssured.given()
//                .log()
//                .all()
//                .pathParam("basePath", "booking")
//                .queryParams("duration.aut", "d")
//                .when()
//                // booking id will be replaced by Remaining 2nd argument in Get method
//                .get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}",2);

        Response response1 = RestAssured.given().queryParams("page", 2).pathParams("base", "api").pathParams("id","users")
                .when().get("https://reqres.in/{base}/{id}");

//                .then()
//                .log()
//                .all();
        System.out.println(response1.body().asPrettyString());
     //   all.statusCode(200);
    }
}
