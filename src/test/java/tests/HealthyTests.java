package tests;

import bases.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class HealthyTests extends BaseTest {

    @Story("Healthy Checker")
    @Description("Verify that the API is healthy")
    @Severity(SeverityLevel.BLOCKER)
    @Test()
    public void health(){
        RestAssured.given(getRequestSpecifications()).filter(new AllureRestAssured())
                .basePath("health-check")
                .get()
                .then().spec(responseSpecification())
                .assertThat()
                .statusCode(200)
                .body("message", Matchers.equalTo("Notes API is Running"));
    }
}
