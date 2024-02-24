package Inteview;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class intResponse {
    public static void main(String[] args) {
     Response res= RestAssured.given().when().get("https://run.mocky.io/v3/ce276e17-6e2d-4517-bc9d-396188a12b5a");
        int num=res.jsonPath().get("id");
        System.out.println(num);
    }
}
