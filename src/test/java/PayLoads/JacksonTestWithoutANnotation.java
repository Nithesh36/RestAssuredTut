package PayLoads;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

public class JacksonTestWithoutANnotation {
    public static void main(String[] args) throws JsonProcessingException {
       String res= RestAssured.given().when().get("https://run.mocky.io/v3/910e4706-dffb-44ae-8f36-6f78a8012c27").body().asString();

        ObjectMapper om=new ObjectMapper();
        EmailUserWithoutProperty em=   om.readValue(res,EmailUserWithoutProperty.class);
        System.out.println(em.getEmail());

    }
}
