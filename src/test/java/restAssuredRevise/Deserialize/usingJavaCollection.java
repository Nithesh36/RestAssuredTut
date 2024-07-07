package restAssuredRevise.Deserialize;

import checkType.MyPersonsPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.sl.In;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class usingJavaCollection {
    public static void main(String[] args) throws JsonProcessingException {
       // RestAssured.baseURI = "https://run.mocky.io/v3/a045a74e-a450-4f89-9b92-5095219ea9ee";
     //   Map<String, Object> map = given().when().get().jsonPath().getMap("[1]");
//        System.out.println(map.get("name") instanceof  String);
//        System.out.println(map.get("id") instanceof Object);
/*
Type Safety: Without a predefined structure (as in POJO classes),
you may lose some type safety, as the data in the collection will be of type Object(data type
 defined in Map)and
 may require casting.


 */
       /* Integer id = (Integer) map.get("id");//// Casting required
        Object name = map.get("name");*/// Casting required

        //  RestAssured.given().body("").pathParams("name","n").queryParams("package"
//
//        ,22).contentType(ContentType.JSON).when().get("goog.com/{name}").then()

//                .log().
        MyPersonsPojo mb = new MyPersonsPojo();
        mb.setId(200);
        mb.setTitle("nik@smsm.com");
        mb.setUserId(22);
       // String responseString = given().get("https://dummyjson.com/posts/add").asString();
        ObjectMapper om = new ObjectMapper();
        String objStr = om.writerWithDefaultPrettyPrinter().writeValueAsString(mb);
        //System.out.println("obj Map: " + om);
//        System.out.println(objStr);
        given().body(objStr).contentType(ContentType.JSON).log().headers().post("https://dummyjson.com/posts/add")
                .then().contentType(ContentType.JSON).extract().response();

        given()
                .get("https://v2.jokeapi.dev/joke/Any?type=single").then().body("lang.length()",

                        Matchers.equalTo(2))
                .body("flags.size()",Matchers.equalTo(6))
                .body("size()",Matchers.equalTo(8));
//                .body(""
    }
}
