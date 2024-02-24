package restAssuredRevise;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;
import java.util.Map;

public class PostUsingExternalJsonFile {

    public static void main(String[] args) throws JsonProcessingException {

            Response response = RestAssured.given().body(new File("src/test/java/restAssuredRevise/postEmail.json"))
                    .contentType(ContentType.JSON).when()   .post("https://reqres.in/api/users");

        System.out.println(response.getBody());




        }
    }