package restAssuredRevise.serialize;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class uisngJavaCollection {
    public static void main(String[] args) {
        Map<String,Object> payloads=new LinkedHashMap<>();
        payloads.put("id",3);
        payloads.put("title","SuperMan");
        payloads.put("author","Alwin");
        RestAssured.given().contentType(ContentType.JSON).body(payloads).when().post("http://localhost:3000/posts").then()
                .log().body().extract().response().as(new TypeRef<HashMap<String,String >>() {
                });


    }
}
