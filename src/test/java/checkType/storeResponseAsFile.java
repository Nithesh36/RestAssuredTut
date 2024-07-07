package checkType;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyExtractionOptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class storeResponseAsFile {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        ResponseBodyExtractionOptions body = RestAssured.given().get("https://reqres.in/api/users/2").then().statusCode(200)
                .extract().body();
        // Write response body to a file using Java NIO
        FileWriter fw = new FileWriter("./nks.json");
        fw.write(body.asPrettyString());
        fw.close();

//        long end=System.currentTimeMillis();
//        System.out.println(end-start);
//        System.out.println(RestAssured.given().get("https://run.mocky.io/v3/262e4e0c-2227-41a3-b783-0f475fcc36b8").time());
        //priority
        //severity example

        //quality assurance and control
        //


    }
}
