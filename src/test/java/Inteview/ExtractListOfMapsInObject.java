package Inteview;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExtractListOfMapsInObject {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .get("https://run.mocky.io/v3/4e8756c6-1f6e-4a55-ba90-9944db4bd649");
/*
"bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    }
 */
        Map<String, String> objects = response.jsonPath().getMap("");
        //System.out.println(objects.get("bookingdates"));
       /* for (Map.Entry<String, Object> mb : objects.entrySet()) {
            if (mb.getKey().equals("bookingdates")) {
                Map<String, String> checkInOut = response.jsonPath().getMap("bookingdates");
                System.out.println("checkout " + checkInOut.get("checkout"));
            } else {
                System.out.println(mb.getKey() + " " + mb.getValue());
            }
        }*/
        for(Map.Entry<String ,String>bookDate:objects.entrySet()){
            if(response.jsonPath().get("bookingdates") instanceof Map){
                System.out.println(response.jsonPath().getMap(""));
            }
        }
        /*List<HashMap<Object, Object>> maps = new LinkedList<>();
        HashMap<Object,Object> map1 = new HashMap<Object, Object>();
        map1.put("name", "nithesh");
        HashMap<Object,Object> map2 = new HashMap<Object, Object>();
        map2.put("name", "Raj");
        maps.add(map1);
        maps.add(map2);
        System.out.println(maps);
        for(HashMap<Object,Object>ls:maps){
            System.out.println(ls);
            for (Map.Entry<Object,Object>map:ls.entrySet())
                System.out.println(map.getValue());
        }*/
    }
}
