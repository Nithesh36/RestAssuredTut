package Inteview;

import Inteview.DesraiizedClasses.ListData;
import Inteview.DesraiizedClasses.Pojo;
import Inteview.DesraiizedClasses.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeserializeObjectMapper extends Pojo {
    public static void main(String[] args) throws IOException {
   /*String res=     RestAssured.given().baseUri("https://reqres.in").when().get("/api/users?page=2").getBody().asString();
        ObjectMapper om = new ObjectMapper();
        //Root root = om.readValue(res,Root.class);
        Root root =om.readValue(RestAssured.given().baseUri("https://reqres.in").when().get("/api/users?page=2").getBody().asString(),Root.class);
        //System.out.println(root.getSupport().getText());*/

        //pojo objects
       /* List<Pojo> resClass=     RestAssured.given().baseUri("https://reqres.in").when().get("/api/users?page=2")
                .jsonPath().getList("data",  Pojo.class);
        System.out.println(resClass.get(0).getFirst_name());*/

     //directly use it in collection
//      List<Map<Object,Object>>lsm =     RestAssured.given().baseUri("https://reqres.in").when().get("/api/users?page=2")
//                .jsonPath().getList("data");
//        System.out.println(lsm.get(1).get("first_name"));


    }
}
