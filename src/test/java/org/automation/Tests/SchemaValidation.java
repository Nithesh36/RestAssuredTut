package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class SchemaValidation {
    String fileName, userJson, location;

    static String users="{\n" +
            "  \"data\": {\n" +
            "    \"id\": 3,\n" +
            "    \"email\": \"emma.wong@reqres.in\",\n" +
            "    \"first_name\": \"Emma\",\n" +
            "    \"last_name\": \"Wong\",\n" +
            "    \"avatar\": \"https://reqres.in/img/faces/3-image.jpg\"\n" +
            "  },\n" +
            "  \"support\": {\n" +
            "    \"url\": \"https://reqres.in/#support-heading\",\n" +
            "    \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
            "  }\n" +
            "}";
    @Test
    public void validateJSONSchema(){

        //base URL
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //obtain response
        given()
                .when().get()

                //verify JSON Schema
                .then().assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File(System.getProperty("user.dir")+"/src/main/resources/schemaUsers.json")));
    }
    @Test
    public void validateJSONSchemaExternalJsonAndHamcrest(){
        String userSchema=System.getProperty("user.dir")+"/src/main/resources/schemaUsers.json";
        //base URL
        RestAssured.baseURI = "https://reqres.in/api/users/3";
        String userJSonPath=System.getProperty("user.dir")+"/src/main/resources/user.json";
        //obtain response
        given()
                .when().get();
        userJson = convertFileIntoString(userJSonPath);
        //verify JSON Schema
        MatcherAssert.assertThat(userJson,JsonSchemaValidator.matchesJsonSchema(new File(userSchema)));
        //MatcherAssert.assertThat(users,JsonSchemaValidator.matchesJsonSchema(new File(userSchema)));
    }
    @Test
    public void validateJSONSchemaInternalStringAndHamcrest(){
        String userSchema=System.getProperty("user.dir")+"/src/main/resources/schemaUsers.json";
        //base URL
        RestAssured.baseURI = "https://reqres.in/api/users/3";
        String userJSonPath=System.getProperty("user.dir")+"/src/main/resources/user.json";
        //obtain response
        given()
                .when().get();
        userJson = convertFileIntoString(userJSonPath);
        //verify JSON Schema
        MatcherAssert.assertThat(users,JsonSchemaValidator.matchesJsonSchema(new File(userSchema)));
        //MatcherAssert.assertThat(users,JsonSchemaValidator.matchesJsonSchema(new File(userSchema)));
    }

    private String convertFileIntoString(String path) {
        String result;
        // initialize result variable
        // we use the get() method of Paths to get the file data
        // we use readAllBytes() method of Files to read byted data from the files
        try {
            result = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // return result to the main() method
        return result;
    }
}

