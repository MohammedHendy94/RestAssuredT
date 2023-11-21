package bases;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static ObjectMapper objectMapper = new ObjectMapper();

    public static RequestSpecification getRequestSpecifcations(){
        return new RequestSpecBuilder().setBaseUri("https://simple-books-api.glitch.me")
                .setContentType(ContentType.JSON).log(LogDetail.ALL).build();
    }

    public static ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }


    @BeforeMethod
    public void beforeMethods(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    /*
    @AfterMethod
    public void afterMethods(ITestResult iTestResult){


    }


     */
}
