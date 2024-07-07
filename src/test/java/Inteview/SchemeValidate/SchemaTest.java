package Inteview.SchemeValidate;

import Inteview.DesraiizedClasses.Flags;
import Inteview.DesraiizedClasses.Jokes;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.io.File;
import java.util.Map;

public class SchemaTest  extends  Flags{
    public static void main(String[] args) {
        System.out.println("valid schema");

        RestAssured.given().get("https://v2.jokeapi.dev/joke/Any")
                .then().log().body().body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/java/Inteview/SchemeValidate/shcema.json")));
         Response response = RestAssured.given().get("https://v2.jokeapi.dev/joke/Any");
                response. then().log().all();
        Jokes DeserialMap = response.as(Jokes.class);
        RestAssured.given().get("").then().body("", Matchers.equalTo(""));

        RestAssured.given().get("").as(Jokes.class);
        RestAssured.given().get("").jsonPath().getList("",Jokes.class);
        RestAssured.given().get("").as(new TypeRef< Map<String,String> >(){});

        Flags flags = DeserialMap.getFlags();
        System.out.println(flags.getExplicit());
//        response.jsonPath()   .get
//        response.jsonPath(). get
        //  response.then().header("methid","get");

                //


                    }
}
