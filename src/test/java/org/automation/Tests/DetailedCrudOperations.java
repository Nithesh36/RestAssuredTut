package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.cucumber.core.internal.com.fasterxml.jackson.databind.type.LogicalType.Map;

public class DetailedCrudOperations {
    public int data = 9;

    @Test
    public void CrudTest() {
        RequestSpecification request = RestAssured.given().baseUri("http://localhost:3000").basePath("/data");
        //----------------Get Method-----------------
//      ValidatableResponse ValidatableRes= request.get().then().log().all();
//      ValidatableRes.statusCode(200);

        //--------------post Method-------------------
        System.out.println("before request");
        Response response = request.when().contentType(ContentType.JSON).body("{\n" +
                "  \"firstName\": \"DHari\",\n" +
                "  \"lastName\": \"Murugan\",\n" +
                "  \"address\": \"cbe\",\n" +
                "  \"phoneNumbers\": \"7540040698\"\n" +
                "}").log().all().post();
        System.out.println("after request");
        ValidatableResponse afterPostCallResponse = response.then().log().all();
//        afterPostCallResponse.body("isEmpty()", Matchers.is(false));
//        af//terPostCallResponse.body("$", Matchers.hasSize(0));
        Map<String ,Object>myItem=new HashMap<>() ;
        myItem=  response.as(new TypeRef< Map < String, Object >>() {});
     System.out.println("size :"+myItem.get("address"));
        //Assert.assertEquals(response.getStatusCode(),201);
       // System.out.println("res body "+response.getBody().asString());

        Response post = RestAssured.given().baseUri("").pathParams("demo", "dd")
                .queryParams("dd", "wel").when().post();

    }

}
