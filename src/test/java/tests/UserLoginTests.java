package tests;

import bases.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojos.LoginInfo;
import readData.ReadTestData;

import java.io.IOException;

public class UserLoginTests extends BaseTest {

    LoginInfo loginInfo;


    @DataProvider
    public String[][] loginTestData() throws IOException, InvalidFormatException {
        ReadTestData reedClientData = new ReadTestData();
        return reedClientData.readLoginTestData();
    }

    @Story("User Login")
    @Description("Log in with a user and verify the profile information")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider ="loginTestData",description = "user login")
    public void validateThatUserLoggedInSuccessfully( String email, String password) throws JsonProcessingException {
        loginInfo = new LoginInfo(email, password);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(loginInfo);
        loginInfo = objectMapper.readValue(reqBody, LoginInfo.class);
        RestAssured.given(getRequestSpecifications()).filter(new AllureRestAssured())
                .basePath("users/login")
                .body(reqBody)
                .post()
                .then().spec(responseSpecification())
                .assertThat()
                .statusCode(200)
                .body("message", Matchers.equalTo("Login successful"))
                .body("data.id", Matchers.equalTo("671274c22b47f201538b66c3"));

    }
}
