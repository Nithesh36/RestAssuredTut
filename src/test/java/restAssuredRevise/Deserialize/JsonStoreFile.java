package restAssuredRevise.Deserialize;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JsonStoreFile {
    public static void main(String[] args) throws IOException {
        String responseAsString = RestAssured.given().get("https://reqres.in/api/users")
                .asPrettyString();

        BufferedWriter bw = new BufferedWriter(new FileWriter("responseFile.json"));
        bw.write(responseAsString);
        bw.close();
        System.out.println("write done");


        //write a specific Fields
        JSONObject jsonObject = new JSONObject();
        /*
        "page": 1,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,
         */
        Response response = RestAssured.given().get("https://reqres.in/api/users");
        jsonObject.put("page", response.jsonPath().getString("page"));
        jsonObject.put("per_page", response.jsonPath().getString("per_page"));
        FileWriter fw = new FileWriter("singleFields.json");
        JSONArray array=new JSONArray(response.jsonPath().getList("data"));
        jsonObject.put("data",array);
        fw.write(jsonObject.toJSONString());
        fw.close();

        /*
          "data": [
        {
            "id": 1,
            "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
            "avatar": "https://reqres.in/img/faces/1-image.jpg"
        },
        {
            "id": 2,
            "email": "janet.weaver@reqres.in",
            "first_name": "Janet",
            "last_name": "Weaver",
            "avatar": "https://reqres.in/img/faces/2-image.jpg"
        },
         */
    }
}
