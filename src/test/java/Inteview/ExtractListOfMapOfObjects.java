package Inteview;

import io.cucumber.java.sl.In;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class ExtractListOfMapOfObjects {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .get("https://run.mocky.io/v3/146b63a3-4ec1-4a93-a4eb-0ba6f0b8c1b7");

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
       List< Map<String, ?> >names= response.jsonPath().getList("");

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
        for(Map<String ,? >name:names){
                for(Map.Entry<String,?>nes:name.entrySet()){
                    System.out.println(nes.getValue());
                }
//            System.out.println(name);
//            Integer id = (Integer) name.get("id");
//            System.out.println(id);


            //   if(name.get("id").toString().equals("30"))
//                System.out.println(name.get("id"));
        }

    }
}
