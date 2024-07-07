package checkType;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CheckIsMap {
    public static void main(String[] args)  {

            RestAssured.given().when().get("https://run.mocky.io/v3/262e4e0c-2227-41a3-b783-0f475fcc36b8")
                    .then().body("", Matchers.instanceOf(Map.class));
           // RestAssured.given().when().get("http://localhost:3000/posts");
      /*  RestAssured.given().when().get("https://run.mocky.io/v3/262e4e0c-2227-41a3-b783-0f475fcc36b8")
                .then().statusCode(200)
                .contentType(ContentType.JSON).time(Matchers.lessThan(300L));*/

        Map<Object, Object> MapDs = RestAssured.given().when().get("https://run.mocky.io/v3/262e4e0c-2227-41a3-b783-0f475fcc36b8").
                jsonPath().getMap("$");
        MyPersonsPojo person = RestAssured.given().when().get("https://run.mocky.io/v3/262e4e0c-2227-41a3-b783-0f475fcc36b8").as(MyPersonsPojo.class);
        //getMap("$",Map.class)
        System.out.println(person.getName());
        List<MyPersonsPojo> list = RestAssured.given().when().get("https://run.mocky.io/v3/a045a74e-a450-4f89-9b92-5095219ea9ee")
                .jsonPath().getList("", MyPersonsPojo.class);
        System.out.println(list.get(0).getAge());
        MyPersonsPojo[] as = RestAssured.given().when().get("https://run.mocky.io/v3/a045a74e-a450-4f89-9b92-5095219ea9ee").as(MyPersonsPojo[].class);
        System.out.println(as[1].getName());
    }
}
