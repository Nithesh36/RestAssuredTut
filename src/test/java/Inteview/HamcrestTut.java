package Inteview;

import io.cucumber.java.bs.A;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;
import static org.hamcrest.Matchers.*;

public class HamcrestTut {
    @Test
    public void checkingKeysInMap() {
//       Response response = RestAssured.given()
//               .get("https://v2.jokeapi.dev/joke/Any?type=single");
//       RestAssured.given()
//               .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("lang",equalTo("en"));
//
//       System.out.println(response.jsonPath().getString("lang"));
//       System.out.println(RestAssured.given()
//               .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").jsonPath().getString("lotto.winners.winnerId"));
//       RestAssured.given()
//               .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().body("lotto.winners.winnerId",
//
//                       Matchers.hasSize(2));
//

//       RestAssured.given()
//               .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("size()",equalTo(14));

        Map<Object, Object> map = given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").jsonPath().getMap("");

        int NestMapSize = 0;
        Map<String, String> mps = new HashMap<>();
        for (Map.Entry<Object, Object> mp : map.entrySet()) {

            if (mp.getValue() instanceof Map) {
                System.out.println(mp.getValue());
                mps = (Map<String, String>) mp.getValue();
                NestMapSize = mps.size();

            }

        }
        System.out.println(mps);
//check string length
        given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("lang.length()",

                        Matchers.equalTo(2));
//       check objects size
        given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("flags.size()",

                        Matchers.equalTo(6));
        //check map contain particular key
        given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("flags",

                        Matchers.hasKey("political"));
        //check object has specified value
        given()
                .get("https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c").then().body("[0].name.firstname",

                        Matchers.equalTo("nithesh"));
        //check status code
        given()
                .get("https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c").then()
                .statusCode(200);

        String url = "https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c";
        String statusMessage = given()
                .get(url).then().extract().statusLine();
        System.out.println(Arrays.toString(statusMessage.split(" ")));
        //check status code Message
        Assert.assertEquals(statusMessage.split(" ")[2], "OK");

//       check array length
        String urlArray = "https://run.mocky.io/v3/06a6d971-41db-4233-8e03-4dc6c1eb4055";
        given().when().get(urlArray).then().body("phoneNumbers.size()", Matchers.equalTo(2));
      //checking object inside array
         given().when().get(urlArray).then().body("phoneNumbers[0].type",Matchers.equalTo("iPhone"))
//               .body("phoneNumbers",Matchers.hasKey("number"));
        ;
       //check array has specified key and values not null
        given()
                .when()
                .get(urlArray)
                .then()
                .assertThat()
                .body("phoneNumbers.type", everyItem(notNullValue())) // Asserting that every 'type' key in the 'phoneNumbers' array is not null
                .body("phoneNumbers.number", everyItem(notNullValue())) ;// Asserting that every 'number' key in the 'phoneNumbers' array is not null
//                .body("phoneNumbers.age",everyItem(notNullValue()));

        //efficient way to check key is there in array
        given()
                .when()
                .get(urlArray)
                .then()
                .assertThat()
                .body("phoneNumbers", everyItem(hasKey("type")))
                .body("phoneNumbers",everyItem(hasKey("number")));
    }

    @Test
    public void checkingSize() {

        //check string length using Hamcrest HasLength; \
        //  if use lang.length() method will through error  /coz return string only
//issue
        given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("lang",

                        Matchers.hasLength(29));
        //solution
        given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("lang.length()",

                        Matchers.equalTo(2));

        //check Objects size
        given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("flags.size()",

                        Matchers.equalTo(6));
        //check String length
//        RestAssured.given()
//                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("lang.length()",
//
//                        Matchers.equalTo(2));


        //check int length
        int idLen = given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().extract().path("id").toString().length();

        Assert.assertEquals(idLen, 7);
        //check array have size
        given()
                .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().body("lotto.winners.winnerId",

                        Matchers.hasSize(8));

        //fetch array length in json Expression in Body and comparing using Hamcrest equalTo
        //will throw Error  : solution: use Hassize() _hamcrest

        given()
                .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().body("lotto.winners[0].numbers.length",

                        Matchers.equalTo(0));

        //check Map has size with 5

        given().get("https://run.mocky.io/v3/c138d665-9bc3-4d33-b985-aebf5610ae23").then().body("[0]",

                Matchers.aMapWithSize(5));

    }

    @Test
    public void checkingArrays() {


        //check for array has multiple Elements
        given()
                .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().body("lotto.winners.winnerId",

                        Matchers.hasItems(29, 54));


        //check array have any one elenent
       /* RestAssured.given()
                .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().body("lotto.winners.winnerId",

                        Matchers.hasItemInArray(04));

        */

        //check array contains all elements
       /* RestAssured.given()    .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().body("lotto.winners.winnerId",

                        Matchers.arrayContaining(23,00));

        */

     /*   RestAssured.given().when().get("http://api.citybik.es/v2/networks").then()
                 .body("networks[1].location", hasKey("city"))
                .body("networks[1].location", hasKey("latitude"))
                .body("networks[1].location", hasKey("country"));


      */
//  Response response = RestAssured.given().when().get("https://run.mocky.io/v3/229c8e01-85ba-4a7f-9583-30e19ea82452");
//        String  responseString=response.asPrettyString();
//        System.out.println(responseString);
//       JsonPath path= response.jsonPath();


//        RestAssured.given().when().get("https://run.mocky.io/v3/229c8e01-85ba-4a7f-9583-30e19ea82452").then().
//                body("[0][0]",equalTo("ЗАО «СитиБайк»"));
//
//        RestAssured.given().when().get("https://run.mocky.io/v3/229c8e01-85ba-4a7f-9583-30e19ea82452").then();
        //  System.out.println(   RestAssured.given().when().get("https://run.mocky.io/v3/229c8e01-85ba-4a7f-9583-30e19ea82452").then().assertThat().extract().response().body().asString());

        //[[0][0]
//  [
//    "ЗАО «СитиБайк»"
//  ],
//  [
//    "Bikeshare Hawaii Island"
//  ]
//]
// */


    }

    @Test
    public void quickTest() {
        //check Objects size
        /*
         "flags": {
        "nsfw": false,

        "religious": false,
        "political": false,
        "racist": false,
        "sexist": false,
        "explicit": false
    },
         */
//        RestAssured.given()
//                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("flags.size()",
//
//                        Matchers.equalTo(6));
//        RestAssured.given()    .get("https://run.mocky.io/v3/c138d665-9bc3-4d33-b985-aebf5610ae23").then().body("[0].size()",
//
//                Matchers.equalTo(57));
        int size = given().get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").jsonPath().getList("lotto.winners.winnerId").size();

        System.out.println(given().get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").jsonPath().getList("lotto.winners.winnerId"));
        System.out.println(size);
        RestAssured.given().when().get("").jsonPath();
    }

}
