package Inteview;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class ExtractListOfMapsInObject {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .get("https://run.mocky.io/v3/e9f7f8fe-f3ed-4c3d-9150-bb481dc5ddb7");
/*
"bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    }
 */
        Map<String, Object> objects = response.jsonPath().getMap("");
        System.out.println(objects.get("bookingdates"));
        for (Map.Entry<String, Object> mb : objects.entrySet()) {
            if (mb.getKey().equals("bookingdates")) {
                Map<String, Object> checkInOut = (Map<String, Object>) objects.get("bookingdates");
                System.out.println("checkout " + checkInOut.get("checkout"));
            } else {
                System.out.println(mb.getKey() + " " + mb.getValue());
            }
        }


    }
}
