package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

public class RequestSpecificationBuildersEx {
//RequestSpecBuilder reqBuild =new RequestSpecBuilder();
RequestSpecification reqSpec;
//@BeforeSuite
//public void setUp(){
//    reqBuild.setBaseUri("https://api.instantwebtools.net")
//    .setContentType(ContentType.JSON);
//
//    reqSpec= reqBuild.build();
//}
    @Test(priority = 1)
    public void getAirlines() {
       String responseExtract= RestAssured.given().log().all().spec(reqSpec).basePath("/v1/airlines/").when().get().then().statusCode(200).log().body().extract().body().asPrettyString();
System.out.println("Response as a String:"+responseExtract);
}
@Test
    public void logALl(){
    RestAssured.given().log().all().baseUri("http://localhost:3000/persons").when().get().then().log().all();

}
//we can log request data  using  given().log().all()
    @Test(priority = 2)
    public void GetSingleAirline(){
        RestAssured.given().spec(reqSpec).basePath("/v1/airlines/{pathToReplace}").pathParams("pathToReplace",1).log().all().when().get().then().statusCode(200).time(Matchers.lessThan(5000L)).log().all();

    }
}


