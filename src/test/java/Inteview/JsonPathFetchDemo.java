package Inteview;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

public class JsonPathFetchDemo {
    public static void main(String[] args) {

        //List of Map objects
//    List<Map<Object,Object>> jokes=  RestAssured.given().when().get("https://icanhazdadjoke.com/slack").jsonPath().getList("attachments");
//    System.out.println(jokes.get(0).get("text"));


        //Map<Map<string,String>

        /*
        Exception in thread "main" java.lang.ClassCastException: class java.util.ArrayList cannot be cast to class java.util.Map (java.util.ArrayList and java.util.Map are in module java.base of loader 'bootstrap')
	at io.restassured.path.json.JsonPath.getMap(JsonPath.java:420)
	at Inteview.JsonPathFetchDemo.main(JsonPathFetchDemo.java:9)
	\Map<Object,Object> jokes=  ( Map<Object,Object>  )RestAssured.given().when().get("https://icanhazdadjoke.com/slack").jsonPath().getMap("attachments");
        System.out.println(jokes);
         */

        //Map-Objects
//        Map<Object,Object>jokes=  RestAssured.given().when().get("https://run.mocky.io/v3/fd394a4a-4d7f-4df1-94c1-ee6ee051407c").jsonPath().getMap("attachments");
//        System.out.println(jokes.get("fallback"));

      /*  String mb=   RestAssured.given().when().get("https://run.mocky.io/v3/fd394a4a-4d7f-4df1-94c1-ee6ee051407c").jsonPath().get("attachments.fallback");
        System.out.println(mb);
        String  name= RestAssured.given().when().get("https://reqres.in/api/users").jsonPath().get("data[0].first_name");
        System.out.println(name);
        String stringNested= RestAssured.given().when().get("https://reqres.in/api/users").jsonPath().get("support.url");
        System.out.println(stringNested);

*/
     List<Map<Object,Object>>Ls=   RestAssured.given().baseUri("https://run.mocky.io/").get("v3/1615c792-dbf9-4dc0-a999-366bca6c13d2")
             .as(new TypeRef<List<Map<Object,Object>>>() {
   });
     Map<Object,Object>maps= (Map<Object, Object>) Ls.get(0).get("attachments");
        System.out.println(maps.get("footer"));
    }
}
