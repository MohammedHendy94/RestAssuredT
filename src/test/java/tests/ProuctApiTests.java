package tests;

import bases.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.*;
import pojos.ProductCreatInfo;
import readData.ReadTestData;

import java.io.IOException;

public class ProuctApiTests extends BaseTest {

    /*
    @BeforeClass
    public void beforeClass(){
        System.out.println("before execute the Class");
    }

    @BeforeMethod
    public void beforeMethods(){
        System.out.println("before execute the method");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before each test");
    }
    */


    @DataProvider
    public String[][] readProductData() throws IOException, InvalidFormatException {
        ReadTestData readTestData = new ReadTestData();
        return readTestData.readproductdata();
    }


    @Test(dataProvider = "readProductData")
    public void createProductTest(String title,String desc, String price, String disc, String rate) throws JsonProcessingException {
        ProductCreatInfo productCreatInfo = new ProductCreatInfo(title,desc,price,disc,rate);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(productCreatInfo);
        RestAssured.given(dummuJsonReqSpec()).filter(new AllureRestAssured())
                .basePath("products/add")
                .body(reqBody)
                .post()
                .then().spec(responseSpecification())
                .assertThat().statusCode(201);
        System.out.println(Thread.currentThread().threadId());
    }


    @Test(dataProvider = "readProductData")
    public void updateProductTest(String title,String desc, String price, String disc, String rate) throws JsonProcessingException {
        ProductCreatInfo productCreatInfo = new ProductCreatInfo(title,desc,price,disc,rate);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(productCreatInfo);
        RestAssured.given(dummuJsonReqSpec()).filter(new AllureRestAssured())
                .basePath("products/1")
                .body(reqBody)
                .put()
                .then().spec(responseSpecification())
                .assertThat().statusCode(200);
        System.out.println(Thread.currentThread().threadId());
    }

    @Test(dataProvider = "readProductData")
    public void patchProductTest(String title,String desc, String price, String disc, String rate) throws JsonProcessingException {
        ProductCreatInfo productCreatInfo = new ProductCreatInfo(title,desc,price,disc,rate);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(productCreatInfo);
        RestAssured.given(dummuJsonReqSpec()).filter(new AllureRestAssured())
                .basePath("products/1")
                .body(reqBody)
                .patch()
                .then().spec(responseSpecification())
                .assertThat().statusCode(200);
        System.out.println(Thread.currentThread().threadId());
    }
    @Test
    public void getTheProducts(){
        RestAssured.given(dummuJsonReqSpec())
                .basePath("products")
                .get()
                .then().spec(responseSpecification())
                .statusCode(200);
        System.out.println(Thread.currentThread().threadId());
    }


}
