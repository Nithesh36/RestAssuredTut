package restAssuredRevise.cmsPack;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.util.Map;

public class playWithGet
{


    public static void main(String[] args) {
        RestAssured.baseURI="https://petstore.swagger.io";
        RequestSpecification given = RestAssured.given().baseUri("").body("");

        Response response = RestAssured.given().when().get("/v2/store/order/2");
        JsonPath jsonPath = RestAssured.given().when().get("/v2/store/order/2").jsonPath();
        ResponseBody body = RestAssured.given().when().get("/v2/store/order/2").body();
        Object ss = RestAssured.given().when().get("/v2/store/order/2").jsonPath().getJsonObject("ss");

        //System.out.println(response.body().asPrettyString());

        Response response1 = RestAssured.given().get("/v2/store/inventory");
        System.out.println(response1.asPrettyString());
        System.out.println(response1.getStatusLine());
        System.out.println(response1.getStatusCode());

        Map<Object, Object> MapJava = response1.as(new TypeRef<Map<Object, Object>>() {
        });
        System.out.println(MapJava);
        System.out.println("--------play---");
        Map<Object, Object> resMap =RestAssured.given().when().get("/v2/store/order/2").jsonPath().getMap("");
        System.out.println(resMap);
        System.out.println();
//header
        System.out.println(response.getBody().jsonPath().getString("quantity"));
        System.out.println(response1.header("content-Type"));
        System.out.println("header Map: "+response1.headers());

//path query param
        Response queryPath = RestAssured.given().log().uri().pathParams("path", "api").
         pathParams("user", "users")
                .queryParams("page", 2).get("https://reqres.in/{path}/{user}");
        System.out.println(queryPath.asPrettyString());
        queryPath.then().body("data[0].first_name.length()", Matchers.equalTo(2));
//        RestAssured.given().get("").jsonPath().getList("s")
        RequestSpecification basic = RestAssured.given().auth().basic("use", "sde");
        Response post = basic.when().post("");
//        post.jsonPath()
        RestAssured.given().queryParams("id","del")
                .pathParams("personId","perspn")
                .get("https://petstore.swagger.io//{perspn}")
                ;

    }
}
