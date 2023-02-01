package DataDriven;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapPayLoad {
//Hash Map will not follow order we entered if u use Put method Better use LinkedHashMap
    Map<String,Object>payload=new LinkedHashMap<>
            (
            Map.of("firstName", "lokesh",
            "lastName", "kavin",
            "age",26,
            "id", 201,
            "address","Chicago, USA",
            "phoneNumbers","123-456-78910")
             );

    @Test
    //post data using Objects -Maps Strings are objects in java
    public  void postUsingMapPayload(){
        RestAssured.given().baseUri("http://localhost:3000").basePath("/persons").contentType(ContentType.JSON).body(payload).when().post().then().log().body();

    }
 @Test
 //post Data using Body(File Body) method
    public  void postUsingExternalJsonFile() {
     String jsonFromFile = System.getProperty("user.dir") + "/src/main/resources/createPost.json";
     try {
         RestAssured.given().baseUri("http://localhost:3000").basePath("/persons").contentType(ContentType.JSON).body(new File(jsonFromFile)).when().post().then().log().body();


     } catch (Exception e) {
        e.printStackTrace();
     }
 }
}
