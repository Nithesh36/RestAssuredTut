package restAssuredRevise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import restAssuredRevise.pojoClass.Category1;
import restAssuredRevise.pojoClass.Root1;
import restAssuredRevise.pojoClass.Tag;
import restAssuredRevise.pojoClass.petPojo;

import java.util.ArrayList;
import java.util.List;

public class SerializeWithoutUsingObjectMaper extends petPojo
{
    public static void main(String[] args) {

        petPojo p=new petPojo();

        p.setId(9);

        p.setId(99);
        p.setName("rasan");
        p.setName("Black");
        p .setPhotoUrls(new ArrayList<String>(List.of("apple")));
        ArrayList<Tag> t=new ArrayList<Tag>();
        Tag tag=new Tag();
        tag.setName("arivu");
        tag.setId(88);
        t.add(tag);
        p.setStatus("available");
        p.setCategory(p.getCategory());
        p.setTags(t);
        String endPoint="https://petstore.swagger.io/v2/pet";
        RestAssured.given().contentType(ContentType.JSON).body(p).post(endPoint)
                .then().log().body();
    }
}
