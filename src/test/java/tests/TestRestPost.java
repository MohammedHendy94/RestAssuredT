package tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import static io.restassured.RestAssured.given;

public class TestRestPost {

    @Test
    public void TestStatusCode(){
     given().when()
                .get("https://dummyjson.com/products/1");

    }
}
