package Inteview;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExtractNestedMapInsideMap

{
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .get("https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c");

        /*
        [
    {
        "name": {
            "firstname": "nithesh",
            "lastName": "kumar"
        },
        "id": 20
    },
    {
        "name": "mk",
        "id": 30
    }
]
         */
        //better way   bcoz we dont know about data type of variables
       Map<Object, Object> FLastName=response.jsonPath().getMap("[0].name");
//        System.out.println(FLastName.get("firstname"));
         for(Map.Entry<Object,Object>m1:FLastName.entrySet()){
             System.out.println(m1.getValue());
         }

        //getJsonObject("[0].name");  to return type as a string ,string
       /*
         result {
            "firstname": "nithesh",
            "lastName": "kumar"
        }
         */
    }
}
