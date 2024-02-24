package Inteview.DesraiizedClasses;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PathParamAndQueryParam {

    public static void main(String[] args) {
        //https://v2.jokeapi.dev/joke/Any?type=single
        Response response = RestAssured.given().pathParams("Category","/joke/Any").queryParams("type","single")
                .get("https://v2.jokeapi.dev/{Category}");
//        System.out.println( response.asPrettyString());
       response.then().log().all();

    }




}
