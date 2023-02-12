package PayLoads;

import io.cucumber.java.sl.In;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class ComplexPayLoadArrayAndObjects {

    static LinkedHashMap<String, LinkedList<Integer>> payloadData = new LinkedHashMap<>();
    //normal method
    //static LinkedHashMap<String, String> skills = new LinkedHashMap<>();
   //productive
    static List<LinkedHashMap<String,Object>>skillSet=new LinkedList<>();


    //static LinkedList<Integer> mobileNum = new LinkedList<>(Arrays.asList(4, 9));
    static List<List<Integer>> mobileNumList = new LinkedList<>();


    static LinkedHashMap<String, Object> firstArray = new LinkedHashMap<>();

    public static void main(String[] args) {

        //skillSet.add();
        mobileNumList.add(List.of(3, 55));
        mobileNumList.add(List.of(99, 22));

        //  payloadData.put("id",valuePairs);
        // System.out.println(payloadData.get("id"));
        firstArray.put("id", 1);
        firstArray.put("name", "nithesh");
        firstArray.put("gender", "male");
        firstArray.put("mobile", mobileNumList.get(1));
      //  skills.put("name", "testing");
       // skills.put("Level", "Expert");
        firstArray.put("skills", skillSet.get(0));

        RestAssured.given().log().all().baseUri("https://reqres.in").basePath("/api/users/2").contentType(ContentType.JSON)
                .body(firstArray)
                .when().get().then().log().all();


    }

}
