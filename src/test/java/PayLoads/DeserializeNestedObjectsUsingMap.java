package PayLoads;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.testng.annotations.Test;

import java.util.*;

public class DeserializeNestedObjectsUsingMap {

    @Test
    public void postNestedObjectInNestedMap() {
        //will return nested objects as a objects we can do chaining extract nested objects
        //we can post this ds a nested Json
        LinkedHashMap<String, LinkedHashMap<String, Object>> parentObject = new LinkedHashMap<>();
        LinkedHashMap<String, Object> nestedObject=new LinkedHashMap<>();
        nestedObject.put("id",780);
        nestedObject.put("email","nk2@gmail.com");
        nestedObject.put("first_name","meena");
        nestedObject.put("last_name","v");
        nestedObject.put("avatar","https://reqres.in/img/faces/2-image.jpg");
        parentObject.put("data", nestedObject);
        RestAssured.
                given().baseUri("http://localhost:3004").
                basePath("/data").contentType(ContentType.JSON).body(parentObject)
                .when().post().then().log().body();
       // System.out.println("response extracted as stored as nested:" + parentObject.get("data1").get("id"));
    }
    @Test
    public void storeNestedObjectInNestedMap() {
        //will return nested objects as a objects we can do chaining extract nested objects
        //we can post this ds a nested Json
        Map<String, Map<String, Object>> Base = new HashMap<>();
        System.out.println("totalBody;" + RestAssured.
                given().baseUri("https://reqres.in").

                basePath("/api/users/2").header(new Header("je","s")).when().get().jsonPath().get());
        Base.put("data", Base.put("data1", RestAssured.
                given().baseUri("https://reqres.in").
                basePath("/api/users/2").when().get().jsonPath().get("data")));
        System.out.println("response extracted as stored as nested:" + Base.get("data1").get("id"));
    }
    @Test
    public void storeObjectIndMap() {
        //it will return nested objects as a string only we can't retrieve
        Map<String, Object> extractObject = new HashMap<>();
        System.out.println("overAllResponse;" + RestAssured.given()
                .baseUri("https://reqres.in").basePath("/api/users/2")
                .when().get().jsonPath().get());
        extractObject.put("bodyAsString", RestAssured.given()
                .baseUri("https://reqres.in").basePath("/api/users/2")
                .when().get().jsonPath().get("data"));
        System.out.println("response as nested:" + extractObject.get("bodyAsString"));
    } @Test
    public void storeAsList() {
        //it will return nested objects as a string only we can't retrieve

        List<Object> id=new ArrayList<>();
                id.add( RestAssured.given()
                .baseUri("https://reqres.in").basePath("api/users").queryParams("page","2")
                      //  https://reqres.in/api/users?page=2
                .when().get().jsonPath().get("data"));
        System.out.println("response as List:" + id.get(0));
    }



}
