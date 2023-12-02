package bases;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tests.RegisterClientAPITests;

import java.io.PrintWriter;
import java.io.StringWriter;

public class BaseTest {

    protected static ObjectMapper objectMapper = new ObjectMapper();
    protected static final Logger loger = LogManager.getLogger(BaseTest.class);

    public static RequestSpecification getRequestSpecifcations(){
        return new RequestSpecBuilder()
                .setBaseUri("https://simple-books-api.glitch.me")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }
    public static ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }



}
