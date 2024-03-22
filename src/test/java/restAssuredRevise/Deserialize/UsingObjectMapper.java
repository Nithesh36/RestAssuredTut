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
/*
In RestAssured, when extracting data from a response, you have the option to extract it into a POJO class or into a normal Java collection. Let's compare the two approaches:

Extracting Data into a POJO Class:

Pros:
Type Safety: Extracting data into a POJO class allows you to define a clear structure for the data, providing type safety at compile time.
Easy Access: Once the data is mapped to a POJO class, you can access it using getter methods, which enhances code readability and maintainability.
Mapping Logic: RestAssured can automatically map the response JSON to the corresponding fields in the POJO class, reducing the amount of manual mapping code you need to write.
Cons:
Additional Classes: You need to define a POJO class for each type of response structure you want to map, which may lead to a larger number of classes in your project.
Overhead: Defining and maintaining POJO classes may add some overhead, especially for simple responses where a POJO class might seem excessive.
Extracting Data into a Normal Java Collection:

Pros:
Flexibility: Extracting data into a normal Java collection, such as a List or Map, provides more flexibility, especially when dealing with dynamic or complex response structures.
No Additional Classes: You don't need to define POJO classes, which simplifies the codebase, especially for small or simple projects.
Cons:
Type Safety: Without a predefined structure (as in POJO classes), you may lose some type safety, as the data in the collection will be of type Object and may require casting.
Manual Mapping: You need to manually parse and map the response JSON into the Java collection, which can be cumbersome and error-prone, especially for nested or complex structures.
In summary, using POJO classes provides better type safety, easier access to data, and
automatic mapping capabilities, but requires additional class definitions.
 On the other hand, using normal Java collections offers more flexibility and simplicity,
  but may result in less type safety and require manual mapping.
  The choice between the two approaches depends on factors such as project complexity
  , data structure, and personal preference.
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

