package Inteview;

import Inteview.DesraiizedClasses.Root;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DeserializeUsingJsonPath {
    public static void main(String[] args) {
        JsonPath jspath= JsonPath.from(RestAssured.given().baseUri("https://reqres.in").when().get("/api/users?page=2")
                .getBody().asString());
        Root responsePojo=jspath.getObject("",Root.class);
        System.out.println(responsePojo.getData().get(2).getEmail());
//        RestAssured.given().baseUri("https://reqres.in").when().get("/api/users?page=2");
    }

}
