package restAssuredRevise.pojoClass;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PostUsingPojo

{
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper om=new ObjectMapper();
        Root root=new Root();
        root.setId(9);
        Category c=new Category();
        c.setId(99);
        c.setName("rasan");
        root.setName("Black");
        root .setPhotoUrls(new ArrayList<String>(List.of("apple")));
      ArrayList<  Tag > t=new ArrayList<Tag>();
      Tag tag=new Tag();
      tag.setName("arivu");
      tag.setId(88);
      t.add(tag);
        root.setStatus("available");
        root.setCategory(c);
        root.setTags(t);

        Response post = RestAssured.given().contentType(ContentType.JSON).body(om.writeValueAsString(root)).when()
                .post("https://petstore.swagger.io/v2/pet\n");

        System.out.println(post.body().asPrettyString());
        RestAssured.given().contentType(ContentType.JSON).body(new HashMap<>().put("name","nitheh"));
        System.out.println("des: Category: "+new ObjectMapper().readValue(post.body().asString(),Root.class).getCategory().getName());

    }
}
