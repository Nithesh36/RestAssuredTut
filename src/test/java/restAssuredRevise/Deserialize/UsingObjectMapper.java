package restAssuredRevise.Deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import restAssuredRevise.pojoClass.*;

import static io.restassured.RestAssured.given;
/*
response:
[
    {
        "name": {
"firstname":"nithesh",
"lastName": "kumar"
},
        "id": 20
    },
    {
        "name": "mk",
        "id": 30
    }
]
 */
public class UsingObjectMapper {


    public static void main(String[] args) {
        RestAssured.baseURI="https://run.mocky.io/v3/99f058b0-1bcc-40b1-978b-d3c4f6abf81c";
        String resString = given().when().get().body().asString();
        ObjectMapper om=new ObjectMapper();
        NamePojo[] namePojo;
        try {
             namePojo = om.readValue(resString, NamePojo[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            String json = om.writeValueAsString(namePojo[0].getName());
            System.out.println("loop through objects");
            for(NamePojo nameObj:namePojo){
                System.out.println(nameObj.getName());
                System.out.println(nameObj.getId());

            }
            //print using objectMapper conversion
            //convert nested object into pojoClass
            System.out.println("conversion of nestedOb");
            FirstLastName firstLastNameObject = om.readValue(json, FirstLastName.class);
            System.out.println(firstLastNameObject.getLastName());
           // System.out.println(namePojo[1].getName());
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

    } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        }
}
