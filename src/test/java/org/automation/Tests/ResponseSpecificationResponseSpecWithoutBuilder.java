package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ResponseSpecificationResponseSpecWithoutBuilder {
    RequestSpecification requestSpecification = RestAssured.given();
    ResponseSpecification responseSpecification = RestAssured.expect();
    @BeforeSuite
    public void setUp() {
        requestSpecification.log().all().baseUri("https://restful-booker.herokuapp.com").basePath("/booking").contentType(ContentType.JSON)
                        .body("{\n" +
                                "    \"firstname\": \"Vinoth\",\n" +
                                "    \"lastname\": \"Jones\",\n" +
                                "    \"totalprice\": 427,\n" +
                                "    \"depositpaid\": true,\n" +
                                "    \"bookingdates\": {\n" +
                                "        \"checkin\": \"2022-02-22\",\n" +
                                "        \"checkout\": \"2022-11-22\"\n" +
                                "    }\n" +
                                "}");
        responseSpecification.statusCode(200);
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.time(Matchers.lessThan(9700L));
    }
    @Test
    public void createBookingWithSeparateReqResSpec() {
        RestAssured.given().spec(requestSpecification).log().all()
                .when().post()
                .then().log()
                .body().spec(responseSpecification);

    }
    @Test
    public void  createBookingWithReqResTogether(){
        RestAssured
                .given(requestSpecification,responseSpecification)
                // Hit the request and get the response
                .post()
                // Validate the response
                .then()
                .log()
                .all();
    }

}
