package hooks;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    @BeforeMethod
    public void beforeMethods(){
        System.out.println("before execute the method");
       // RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
