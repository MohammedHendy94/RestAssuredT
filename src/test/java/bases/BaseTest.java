package bases;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    protected  String accessToken ;
    protected static ObjectMapper objectMapper = new ObjectMapper();
    protected static final Logger loger = LogManager.getLogger(BaseTest.class);

    public static RequestSpecification getRequestSpecifications(){
        return new RequestSpecBuilder()
                .setBaseUri("https://practice.expandtesting.com/notes/api")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    public static ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }



}
