package restAssuredRevise.cmsPack;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class DateAPi {
    public static void main(String[] args) {
        Response response = RestAssured.given().get("https://timeapi.io/api/Time/current/zone?timeZone=Europe/Amsterdam");
       response.then().body("date", Matchers.equalTo("04/05/2024"));
    response.jsonPath();
    }
}
