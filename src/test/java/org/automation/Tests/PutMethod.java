package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Map;

public class PutMethod {
    @Test
    public void putUsingAuthorizationBasic() {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("{basePath}/{bookingId}")
                .pathParams(Map.of("basePath", "booking", "bookingId", 3889))
                .headers("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                //4fe0bc1aedc5549
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\": \"Alagu\",\n" +
                        "    \"lastname\": \"Allen\",\n" +
                        "    \"totalprice\": 111,\n" +
                        "    \"depositpaid\": true,\n" +
                        "    \"bookingdates\": {\n" +
                        "        \"checkin\": \"2018-01-01\",\n" +
                        "        \"checkout\": \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\": \"super bowls\"\n" +
                        "}")
                .when()
                //2nd argument will  map  based on index Booking will replace basePath vise versa
                .put()
                .then()
                .log()
                .all();
    }

    @Test
    public void putUsingToken() {
        String token = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("auth").
                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}").
                log()
                .all().
                when().
                post()
                //validate the Response   below code
                .then()
                //log the response after Hit the  End point
                .log()
                .all().extract().jsonPath().getString("token");

        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("{basePath}/{bookingId}")
                .pathParams(Map.of("basePath", "booking", "bookingId", 1893))
                .cookie("token", token)
                //4fe0bc1aedc5549
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\": \"Gopal\",\n" +
                        "    \"lastname\": \"Allen\",\n" +
                        "    \"totalprice\": 111,\n" +
                        "    \"depositpaid\": true,\n" +
                        "    \"bookingdates\": {\n" +
                        "        \"checkin\": \"2018-01-01\",\n" +
                        "        \"checkout\": \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\": \"super bowls\"\n" +
                        "}")
                .when()
                //2nd argument will  map  based on index Booking will replace basePath vise versa
                .put()
                .then()
                .log()
                .all();
    }

}
