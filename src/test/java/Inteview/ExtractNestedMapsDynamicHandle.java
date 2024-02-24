package Inteview;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.*;

public class ExtractNestedMapsDynamicHandle {
    /*
    Dynamically handled based on type of object we  received in response
     */
//    public static void main(String[] args) throws JsonProcessingException {
//        Response response = RestAssured.given()
//                .get("https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c");
//      List<  Map<Object,Object > >nestMap= response.jsonPath().getList("");
//      String [] nestedMapArray =  nestMap.get(0).get("name").toString().split("=");
//     //   {firstname=nithesh, lastName=kumar}
////        System.out.println(nestMap);
//        System.out.println(Arrays.toString(nestMap.get(0).get("name").toString().split("=")));
//        String firstName = nestedMapArray[0].substring(1);
//        String lastName = nestedMapArray[1].substring(1);
//        System.out.println(firstName  +"  : "+lastName);

    public static void main(String[] args) throws JsonProcessingException {
//https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c
        //https://run.mocky.io/v3/0c1899aa-6dff-4dfd-a4c0-3a316ff8f3a3
            Response response = RestAssured.given()
                    .get("https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c");
        //
            List<Map<Object, Object>> nestMap = response.jsonPath().getList("");
            if (!nestMap.isEmpty()) {
                Object nameValue = nestMap.get(0).get("name");

                if (nameValue instanceof String) {
                    // If "name" is a string, it will split by '=' (not applicable for the first object in the provided JSON)
                    //String[] nestedMapArray = nameValue.toString().split("=");
                    System.out.println(nameValue);
                    // Process the split values if necessary
                    // Note: This section won't apply to the first object in your JSON response
                } else if (nameValue instanceof Map) {
                    // If "name" is an object, access its properties directly
                    Map<?, ?> nameMap = (Map<?, ?>) nameValue;
                    Object firstName = nameMap.get("firstname");
                    Object lastName = nameMap.get("lastName");

                    if (firstName != null && lastName != null) {
                        System.out.println(firstName + " : " + lastName);
                    }
                }


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
//     LinkedHashMap<String,String > nestMap= response.jsonPath().getJsonObject("");
                // System.out.println(nestMap.get("name").get("lastName"));
//        ObjectMapper om=new ObjectMapper();
//        System.out.println(response.getBody().asString());
////        System.out.println(response.getBody().toString());
//        String json = om.writeValueAsString(response.getBody().asString());
//        System.out.println(json);
//        JSONObject jsonArray = new JSONObject(json.substring(1,json.length()-1));
//        System.out.println(json);
//        JSONObject nameJson = (JSONObject) jsonArray.get(0);
//        System.out.println(nameJson);


//        NestdMapPojo ns=om.readValue(response.asString(),NestdMapPojo.class);
                //Read as a List
//        ObjectMapper objectMapper = new ObjectMapper();
////        List<Map<String, Object>> responseList = objectMapper.readValue(response.getBody().asString()
////                , new TypeReference<List<Map<String, Object>>>() {});
//        //System.out.println(Arrays.toString(responseList.get(0).get("name").toString().split("=")));
//        //System.out.println(responseList.get(1).get("id"));
////        NestdMapPojo[] users = response.getBody().as(NestdMapPojo[].class);
//        List<Map<String, Object>> responseList = objectMapper.readValue(response.getBody().asString()
//                , new TypeReference<List<Map<String, Object>>>() {});
//        for ( Map<String,Object> res :   responseList ) {
//            if ( res.get("name") != null && res.get("name") != ""  ){
//                System.out.println(res.get("name"));
////                JSONObject resName = (JSONObject) res.get("name");
////                System.out.println(resName);
////                if ( resNAme.toString().contains("{") ) {
////                    Map<String,String> nameMap = objectMapper.convertValue(response
////                            , new TypeReference<Map<String, String>>() {});
////                    System.out.println(nameMap.get("firstname"));
////                }
//
//            }
//        }

//        System.out.println(users[0].getFirstname());
            }
        }
    }