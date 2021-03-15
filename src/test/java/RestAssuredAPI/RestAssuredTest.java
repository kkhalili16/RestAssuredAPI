package RestAssuredAPI;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RestAssuredTest {

    @Test
    public void test_1(){
       // Response response = RestAssured.get("https://reqres.in/api/users?page=2");
       Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getSessionId());
        System.out.println(response.getStatusLine());
        System.out.println(response.contentType());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));
        int responseCode = response.getStatusCode();
        Assert.assertEquals(responseCode,200);
    }


    @Test
    public void test_2(){
        baseURI="https://reqres.in/api/users?page=2";

        given().
                get(baseURI).
        then().
                statusCode(200).
                body("data[1].id",equalTo(8)).
                log().all();



    }





}
