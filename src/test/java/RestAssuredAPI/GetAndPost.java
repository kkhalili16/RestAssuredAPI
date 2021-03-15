package RestAssuredAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;


public class GetAndPost {

    @Test
    public void GetAndPostExample(){
        baseURI="https://reqres.in/api";


        given().
                get("/users?page=2").
        then().
                statusCode(200).log().all().
                body("data[4].first_name",equalTo("George")).
                body("data.first_name",hasItems("George","Byron"));


    }
}
