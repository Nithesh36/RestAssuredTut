package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseBuilderSpec {
    ResponseSpecBuilder builder;
    ResponseSpecification rspec;
    @BeforeClass
    public void requestSpec () {

        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="/api/users/2";
        builder = new ResponseSpecBuilder ();

        builder.expectContentType (ContentType.JSON);
        builder.expectStatusCode (200);
        rspec= builder.build ();

    }
    @Test
    public void Test01() {
        given()
                .when ()
                .get ()
                .then ()
                .spec (rspec);
    }

}
