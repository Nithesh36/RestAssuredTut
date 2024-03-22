package restAssuredRevise.Deserialize;

import io.cucumber.java.sl.In;
import io.restassured.RestAssured;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class usingJavaCollection {
    public static void main(String[] args) {
        RestAssured.baseURI="https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c";
        Map<String, Object> map = given().when().get().jsonPath().getMap("[1]");
//        System.out.println(map.get("name") instanceof  String);
//        System.out.println(map.get("id") instanceof Object);
/*
Type Safety: Without a predefined structure (as in POJO classes),
you may lose some type safety, as the data in the collection will be of type Object(data type
 defined in Map)and
 may require casting.


 */
        Integer id = (Integer) map.get("id");//// Casting required
        Object name = map.get("name");// Casting required

    }
}
