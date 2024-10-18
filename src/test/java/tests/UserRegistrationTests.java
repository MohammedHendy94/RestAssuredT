package tests;

import bases.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojos.UserInfo;
import readData.ReadTestData;

import java.io.IOException;

public class UserRegistrationTests extends BaseTest {


    UserInfo userInfo;

    @DataProvider
    public String[][] userTestData() throws IOException, InvalidFormatException {
        ReadTestData reedClientData = new ReadTestData();
        return reedClientData.readUserTestData();
    }

    @Story("User Registration")
    @Description("Register a new user and verify it’s created")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider ="userTestData",description = "user register")
    public void validateThatNewUserRegisteredSuccessfully(String name, String email, String password) throws JsonProcessingException {
        userInfo = new UserInfo(name,email, password);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userInfo);
        userInfo = objectMapper.readValue(reqBody, UserInfo.class);
                RestAssured.given(getRequestSpecifications()).filter(new AllureRestAssured())
                        .basePath("users/register")
                        .body(reqBody)
                        .post()
                        .then().spec(responseSpecification())
                        .assertThat()
                        .statusCode(201)
                        .body("message", Matchers.equalTo("User account created successfully"));

    }
}
