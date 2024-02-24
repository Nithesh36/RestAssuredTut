package Inteview;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class AssertUsingTestNg {
    @Test
    public   void TestNgAssert() {
     JsonPath path= RestAssured.given()

                .when() .get("https://gbfs.bcycle.com/bcycle_elpaso/gbfs.json").jsonPath();

        Response response=RestAssured.given()

                .when() .get("https://gbfs.bcycle.com/bcycle_elpaso/gbfs.json");
        Assert.assertEquals(path.get("data.en.feeds[2].name"),"system_information");
      //  Assert.assertEquals(response.(),200);
     JsonPath js=   RestAssured.given().when().get("https://run.mocky.io/v3/b70891ad-faa7-414c-a700-aff3412a764c").jsonPath();
       //comparing list values
        List<String>ls=new LinkedList<>(Arrays.asList(    "Mosmcow",
                "demi"));
    Assert.assertEquals(js.getList("networks[0].location.city"),ls);
//        String expectBody="{\n" +
//                "    \"ttl\": 60,\n" +
//                "    \"data\": {\n" +
//                "        \"en\": {\n" +
//                "            \"feeds\": [\n" +
//                "                {\n" +
//                "                    \"url\": \"https://gbfs.bcycle.com/bcycle_elpaso/gbfs.json\",\n" +
//                "                    \"name\": \"gbfs\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"url\": \"https://gbfs.bcycle.com/bcycle_elpaso/gbfs_versions.json\",\n" +
//                "                    \"name\": \"gbfs_versions\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"url\": \"https://gbfs.bcycle.com/bcycle_elpaso/system_information.json\",\n" +
//                "                    \"name\": \"system_information\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"url\": \"https://gbfs.bcycle.com/bcycle_elpaso/station_information.json\",\n" +
//                "                    \"name\": \"station_information\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"url\": \"https://gbfs.bcycle.com/bcycle_elpaso/station_status.json\",\n" +
//                "                    \"name\": \"station_status\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"url\": \"https://gbfs.bcycle.com/bcycle_elpaso/system_pricing_plans.json\",\n" +
//                "                    \"name\": \"system_pricing_plans\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"url\": \"https://gbfs.bcycle.com/bcycle_elpaso/system_regions.json\",\n" +
//                "                    \"name\": \"system_regions\"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    },\n" +
//                "    \"version\": \"1.1\",\n" +
//                "    \"last_updated\": 1702569041\n" +
//                "}";
////        Assert.assertEquals(response.body().asString(),expectBody);
//
//        // Convert string to JSON object
//        JSONObject jsonObject = new JSONObject(expectBody);
//
//
//              RestAssured.given() .when() .get("https://gbfs.bcycle.com/bcycle_elpaso/gbfs.json").then().body("", Matchers.equalTo(jsonObject.toString()));
//        RestAssured.given()
//
//                .when() .get("https://gbfs.bcycle.com/bcycle_elpaso/gbfs.json").then().assertThat().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void testObjectsMap(){
        Response response=RestAssured.given()

                .when() .get("https://run.mocky.io/v3/a7eca57b-d0b9-4e08-bc11-7877dba9d994");
        JsonPath path=response.jsonPath();

        List<Map<String, String>> listOfMaps = List.of(Map.of("url", "https://gbfs.bcycle.com/bcycle_elpaso/gbfs.json",
                "name", "gbfs"), Map.of("js", "https://gbfs.bcjson",
                "loc", "cbe"));

        Assert.assertEquals(path.get("data.en.feeds"),listOfMaps);

//        response.ge
       RestAssured.given()

                .when() .get("https://run.mocky.io/v3/a7eca57b-d0b9-4e08-bc11-7877dba9d994").then().body("data.en.feeds[1]"
                       ,Matchers.hasValue("cbe")).body("data.en.feeds[1]"
                       ,Matchers.hasValue("https://gbfs.bcjson"));

    }
}
