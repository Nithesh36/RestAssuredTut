package restAssuredRevise.cmsPack;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class HamCrestRevise {

    @Test
    public void checkObjectArrayValue() {
        //status code check
        RestAssured.given().when().get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().statusCode(404);

        RestAssured.given().when().get("").then().body("ff", hasKey(""));
        //  RestAssured.given().when().get("").then().body("ff",Matchers.has(""));
        //check key
        RestAssured.given().when().get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then()
                .body("lotto", hasKey("winning-numbers"));
        //check if all items in array
        RestAssured.given().when().get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then()
                .body("lotto.winning-numbers", arrayContaining(2, 45, 34, 23, 7, 5, 3));
        RestAssured.given().when().get();
        //check if a Key has a specified value in Map
        RestAssured.given().when().get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then()
                .body("lotto.winners[0].winnerId", equalTo(23));

        //check for multiple keys
        RestAssured.given().when().get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then()
                .body("lotto", hasKey("winners"))
                .body("lotto", hasKey("winning-numbers"))
                .body("lotto", hasKey("lottoId"))
                .body("lotto", Matchers.arrayContainingInAnyOrder(1, 3, 4));

        //check content Type
        RestAssured.given().when().get("").then().contentType(ContentType.JSON);

        RestAssured.given().when().get("d").jsonPath().getJsonObject("");
        RestAssured.given().when().get("").jsonPath();
        RestAssured.given().when().get("").jsonPath();

        RestAssured.given().when().get("").then().body("",Matchers.greaterThan(11));
        /*

         */
        ExtractableResponse<Response> extract = RestAssured.given().when().get("").then().statusCode(22)
                .contentType(ContentType.JSON)
                .header("url", "ss").
                extract();
extract.response();

        Response response = RestAssured.given().when().get("");
//Matchers.(Integer.class))


    }
}
