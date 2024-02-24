package Inteview;

import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.Matchers.*;

public class HamcrestTut {
   @Test
    public void checkingKeysInMap(){
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

       Map<Object, Object> map = RestAssured.given()
               .get("https://v2.jokeapi.dev/joke/Any?type=single").jsonPath().getMap("");

       int NestMapSize = 0;
       for(Map.Entry<Object,Object>mp:map.entrySet()){
           if(mp.getValue() instanceof Map){
               Map<String,String>mps= (Map<String, String>) mp.getValue();
               NestMapSize=mps.size();
           }
       }
       System.out.println(NestMapSize);


   }
   @Test
    public void checkingSize(){

       //check string length using Hamcrest HasLength; \
        //  if use lang.length() method will through error  /coz return string only
//issue
        RestAssured.given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("lang",

                        Matchers.hasLength(29));
        //solution
        RestAssured.given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("lang.length()",

                        Matchers.equalTo(2));

       //check Objects size
       RestAssured.given()
               .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("flags.size()",

                       Matchers.equalTo(6));
        //check String length
//        RestAssured.given()
//                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("lang.length()",
//
//                        Matchers.equalTo(2));


        //check int length
        int idLen=    RestAssured.given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().extract().path("id").toString().length();

        Assert.assertEquals(idLen,7);
        //check array have size
        RestAssured.given()
                .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().body("lotto.winners.winnerId",

                        Matchers.hasSize(8));

        //fetch array length in json Expression in Body and comparing using Hamcrest equalTo
        //will throw Error  : solution: use Hassize() _hamcrest

   RestAssured.given()
                .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().body("lotto.winners[0].numbers.length",

                       Matchers.equalTo(0));

        //check Map has size with 5

        RestAssured.given()    .get("https://run.mocky.io/v3/c138d665-9bc3-4d33-b985-aebf5610ae23").then().body("[0]",

                Matchers.aMapWithSize(5));

    }

    @Test
    public void checkingArrays(){


       //check for array has multiple Elements
       RestAssured.given()
                .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").then().body("lotto.winners.winnerId",

                        Matchers.hasItems(29,54));



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
    public  void quickTest(){
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
     int size=   RestAssured.given()    .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").jsonPath().getList("lotto.winners.winnerId").size();

        System.out.println(RestAssured.given()    .get("https://run.mocky.io/v3/7eb5ac32-b0b4-479c-951d-f02ad8d02aa3").jsonPath().getList("lotto.winners.winnerId"));
        System.out.println(size);

    }

}
