package Inteview;

import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.Map;

public class DeserializeAsFunction {
/*
{
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
 */
    //using Type Ref
    public static void main(String[] args) {
        Response response=RestAssured.given().baseUri("https://reqres.in").when().get("/api/users/2");
    Map<String,Map<String ,Object>> res=
            response.as(new TypeRef<Map<String, Map<String,Object >>>() {
        });
        System.out.println(res);
    }
}
