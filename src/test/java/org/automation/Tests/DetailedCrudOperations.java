package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DetailedCrudOperations {
    public int data = 9;

    @Test
    public void CrudTest() {
        RequestSpecification request = RestAssured.given().baseUri("http://localhost:3000").basePath("/persons");
        //----------------Get Method-----------------
//      ValidatableResponse ValidatableRes= request.get().then().log().all();
//      ValidatableRes.statusCode(200);

        //--------------post Method-------------------
        Response response = request.when().contentType(ContentType.JSON).body("{\n" +
                "    \"firstName\": \"Hari\",\n" +
                "    \"lastName\": \"Murugan\",\n" +
                "    \"address\": \"cbe\",\n" +
                "    \"phoneNumbers\": \"7540040698\",\n" +
                "    \"id\": 39\n" +
                "  }").post();
        ValidatableResponse afterPostCallResponse = response.then().log().all();
        afterPostCallResponse.statusCode(201);
    }

}
