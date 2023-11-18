package bases;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static ObjectMapper objectMapper = new ObjectMapper();
    @BeforeMethod
    public void beforeMethods(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
