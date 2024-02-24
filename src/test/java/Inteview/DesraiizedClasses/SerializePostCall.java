package Inteview.DesraiizedClasses;

import Inteview.EmailPojo;
import Inteview.ResponseTokenPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SerializePostCall {
    public static void main(String[] args) throws JsonProcessingException {

        EmailPojo emails=new EmailPojo();
        emails.setEmail("eve.holt@reqres.in");
        emails.setPassword("pistol");
        ObjectMapper om=new ObjectMapper();

        Response res= RestAssured.given().body(om.writerWithDefaultPrettyPrinter().writeValueAsString(emails)).contentType(ContentType.JSON)
                .post("https://reqres.in/api/register");



         //Deserialize
        ResponseTokenPojo TokenAndId=res.as(ResponseTokenPojo.class);
        System.out.println("Deserialised  :  "+TokenAndId.getToken());

       // om.readValue(res.asString(),ResponseTokenPojo.class);

        /*
        {
    "id": 4,
    "token": "QpwL5tke4Pnpja7X4"
}
         */
    }
}
