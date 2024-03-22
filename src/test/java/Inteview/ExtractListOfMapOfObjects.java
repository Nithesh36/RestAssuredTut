package Inteview;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class ExtractListOfMapOfObjects {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .get("https://run.mocky.io/v3/c3e37bd3-8f72-4f1d-a71b-612bd278c7a8");

//        List<Map<String, ?>> responseList = response.jsonPath();


        /*
        [
    {
        "name": "nk",
        "id": 20
    },
    {
        "name": "mk",
        "id": 30
    }
]
         */
       List< Map<Object, Object> >names= response.jsonPath().getList("");

        /*

    {
        "name": "nk",
        "id": 20
    }

         */
      //  if(responseList.get(1).get("id").toString().equals("30"))
           // System.out.println(responseList.get(0).get("id"));
//           System.out.println(names.get(0).get("name"));

        //System.out.println(response.jsonPath().getString("[1].id"));
        for(Map<Object ,Object >name:names){
//            for(Map.Entry<Object,Object>nes:name.entrySet()){
//                System.out.println(nes.getValue());
//            }
            System.out.println(name);
         //   if(name.get("id").toString().equals("30"))
//                System.out.println(name.get("id"));
        }

    }
}
