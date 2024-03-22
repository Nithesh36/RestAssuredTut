package restAssuredRevise.Deserialize;

import io.restassured.RestAssured;

import java.util.Map;
import restAssuredRevise.pojoClass.*;
import static io.restassured.RestAssured.given;

public class withoutUsingObjectMapper {
    public static void main(String[] args) {
        RestAssured.baseURI="https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c";
        NamePojo[] map = given().when().get().as(NamePojo[].class);
        System.out.println(map[0].getName());

    }
}
