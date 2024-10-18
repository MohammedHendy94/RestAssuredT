package tests;

import bases.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CartsApiTests extends BaseTest {

    @Test
    public void getAllCarts (){
      RestAssured.given(dummuJsonReqSpec())
                .basePath("carts")
                .get()
                .then().spec(responseSpecification())
                .statusCode(200);
     System.out.println(Thread.currentThread().threadId());
    }

    @Test
    public void deleteCart(){
        RestAssured.given(dummuJsonReqSpec())
                .basePath("carts/1")
                .delete()
                .then().spec(responseSpecification())
                .statusCode(200);
        System.out.println(Thread.currentThread().threadId());
    }





}
