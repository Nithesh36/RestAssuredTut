package org.automation.Tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.*;

public class PlayWithJson {
    static String request = "   {\n" +
            "    \"medications\":[{\n" +
            "            \"aceInhibitors\":[{\n" +
            "                \"name\":\"lisinopril\",\n" +
            "                \"strength\":\"10 mg Tab\",\n" +
            "                \"dose\":\"1 tab\",\n" +
            "                \"route\":\"PO\",\n" +
            "                \"sig\":\"daily\",\n" +
            "                \"pillCount\":\"#90\",\n" +
            "                \"refills\":\"Refill 3\"\n" +
            "            }],\n" +
            "            \"antianginal\":[{\n" +
            "                \"name\":\"nitroglycerin\",\n" +
            "                \"strength\":\"0.4 mg Sublingual Tab\",\n" +
            "                \"dose\":\"1 tab\",\n" +
            "                \"route\":\"SL\",\n" +
            "                \"sig\":\"q15min PRN\",\n" +
            "                \"pillCount\":\"#30\",\n" +
            "                \"refills\":\"Refill 1\"\n" +
            "            }],\n" +
            "            \"anticoagulants\":[{\n" +
            "                \"name\":\"warfarin sodium\",\n" +
            "                \"strength\":\"3 mg Tab\",\n" +
            "                \"dose\":\"1 tab\",\n" +
            "                \"route\":\"PO\",\n" +
            "                \"sig\":\"daily\",\n" +
            "                \"pillCount\":\"#90\",\n" +
            "                \"refills\":\"Refill 3\"\n" +
            "            }],\n" +
            "            \"betaBlocker\":[{\n" +
            "                \"name\":\"metoprolol tartrate\",\n" +
            "                \"strength\":\"25 mg Tab\",\n" +
            "                \"dose\":\"1 tab\",\n" +
            "                \"route\":\"PO\",\n" +
            "                \"sig\":\"daily\",\n" +
            "                \"pillCount\":\"#90\",\n" +
            "                \"refills\":\"Refill 3\"\n" +
            "            }],\n" +
            "            \"diuretic\":[{\n" +
            "                \"name\":\"furosemide\",\n" +
            "                \"strength\":\"40 mg Tab\",\n" +
            "                \"dose\":\"1 tab\",\n" +
            "                \"route\":\"PO\",\n" +
            "                \"sig\":\"daily\",\n" +
            "                \"pillCount\":\"#90\",\n" +
            "                \"refills\":\"Refill 3\"\n" +
            "            }],\n" +
            "            \"mineral\":[{\n" +
            "                \"name\":\"potassium chloride ER\",\n" +
            "                \"strength\":\"10 mEq Tab\",\n" +
            "                \"dose\":\"1 tab\",\n" +
            "                \"route\":\"PO\",\n" +
            "                \"sig\":\"daily\",\n" +
            "                \"pillCount\":\"#90\",\n" +
            "                \"refills\":\"Refill 3\"\n" +
            "            }]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"labs\":[{\n" +
            "        \"name\":\"Arterial Blood Gas\",\n" +
            "        \"time\":\"Today\",\n" +
            "        \"location\":\"Main Hospital Lab\"      \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"BMP\",\n" +
            "        \"time\":\"Today\",\n" +
            "        \"location\":\"Primary Care Clinic\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"BNP\",\n" +
            "        \"time\":\"3 Weeks\",\n" +
            "        \"location\":\"Primary Care Clinic\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"BUN\",\n" +
            "        \"time\":\"1 Year\",\n" +
            "        \"location\":\"Primary Care Clinic\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"Cardiac Enzymes\",\n" +
            "        \"time\":\"Today\",\n" +
            "        \"location\":\"Primary Care Clinic\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"CBC\",\n" +
            "        \"time\":\"1 Year\",\n" +
            "        \"location\":\"Primary Care Clinic\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"Creatinine\",\n" +
            "        \"time\":\"1 Year\",\n" +
            "        \"location\":\"Main Hospital Lab\"  \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"Electrolyte Panel\",\n" +
            "        \"time\":\"1 Year\",\n" +
            "        \"location\":\"Primary Care Clinic\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"Glucose\",\n" +
            "        \"time\":\"1 Year\",\n" +
            "        \"location\":\"Main Hospital Lab\"  \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"PT/INR\",\n" +
            "        \"time\":\"3 Weeks\",\n" +
            "        \"location\":\"Primary Care Clinic\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"PTT\",\n" +
            "        \"time\":\"3 Weeks\",\n" +
            "        \"location\":\"Coumadin Clinic\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"TSH\",\n" +
            "        \"time\":\"1 Year\",\n" +
            "        \"location\":\"Primary Care Clinic\"    \n" +
            "        }\n" +
            "    ],\n" +
            "    \"imaging\":[{\n" +
            "        \"name\":\"Chest X-Ray\",\n" +
            "        \"time\":\"Today\",\n" +
            "        \"location\":\"Main Hospital Radiology\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"Chest X-Ray\",\n" +
            "        \"time\":\"Today\",\n" +
            "        \"location\":\"Main Hospital Radiology\"    \n" +
            "        },\n" +
            "        {\n" +
            "        \"name\":\"Chest X-Ray\",\n" +
            "        \"time\":\"Today\",\n" +
            "        \"location\":\"Main Hospital Radiology\"    \n" +
            "        }\n" +
            "    ]\n" +
            "}";
    static JsonPath json = new JsonPath(request);

    //    static List<String>extractList =
    public static void convertObjectsToMap() {
        try {

            RestAssured.baseURI = "https://api.stackexchange.com/";
            RestAssured.basePath = "2.3/answers";
            RestAssured.given().queryParams(Map.of("todate", 1675123200, "order", "desc", "sort", "activity", "site", "stackoverflow")
            ).when().get().then().log().body();
            LinkedHashMap<String, Object> map = RestAssured.given().queryParams(Map.of("todate", 1675123200, "order", "desc", "sort", "activity", "site", "stackoverflow")
            ).when().get().jsonPath().get("items[0].owner");
            //RestAssured.given().when().get().jsonPath().getList()
            System.out.println("response :" + map.get("display_name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertToListFromResponse() {
        RestAssured.baseURI = "https://api.stackexchange.com/";
        RestAssured.basePath = "2.3/answers";
        RestAssured.given().queryParams(Map.of("order", "desc", "sort", "activity", "site", "stackoverflow")
        ).when().get().then().log().body();

        List  <Object> responseList=   RestAssured.given().queryParams(Map.of("order", "desc", "sort", "activity", "site", "stackoverflow")
        ).when().get().jsonPath().getList("items[16].posted_by_collectives[0].tags");
        System.out.println("Response -Crud Method:"+responseList);
    }

    public static void main(String[] args) {
        //    convertObjectsToMap();
        convertToListFromResponse();
    }
}
