package tests;

import bases.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojos.ChangePassword;
import readData.ReadTestData;

import java.io.IOException;


@Epic("Digitinary API Automation")
@Feature("Rest Assured")
public class ChangePasswordTests extends BaseTest {

    ChangePassword changePassword;
    @DataProvider
    public String[][] readChangePassTestData() throws IOException, InvalidFormatException {
        ReadTestData reedClientData = new ReadTestData();
        return reedClientData.readChangePassTestData();
    }

    @Story("Change Password")
    @Description("Change the password and verify it’s updated successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider ="readChangePassTestData",description = "change password")
    public void validateThatUserUpdatedSuccessfully( String currentPass, String newPass) throws JsonProcessingException {
        changePassword = new ChangePassword(currentPass,newPass);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(changePassword);
        changePassword = objectMapper.readValue(reqBody, ChangePassword.class);
        RestAssured.given(getRequestSpecifications()).filter(new AllureRestAssured())
                .basePath("users/change-password")
                .body(reqBody).header("x-auth-token", "dc88e0b2845e4eaca0de7f7b9018e54289d62c85c7414fa68338afcbce0136c1")
                .post()
                .then().spec(responseSpecification())
                .assertThat()
                .statusCode(200)
                .body("message", Matchers.equalTo("The password was successfully updated"));
    }


}
