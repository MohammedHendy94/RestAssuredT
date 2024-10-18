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
import pojos.UpdateProfile;
import readData.ReadTestData;

import java.io.IOException;

public class UpdateProfileInfoTests extends BaseTest {
    UpdateProfile updateProfile;

    @DataProvider
    public String[][] updateTestData() throws IOException, InvalidFormatException {
        ReadTestData reedClientData = new ReadTestData();
        return reedClientData.readUpdateUserTestData();
    }

    @Story("User Update")
    @Description("Update profile information and verify it’s updated successfully")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider ="updateTestData",description = "user update")
    public void validateThatUserUpdatedSuccessfully( String name, String phone, String company) throws JsonProcessingException {
        updateProfile = new UpdateProfile(name, phone, company);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(updateProfile);
        updateProfile = objectMapper.readValue(reqBody, UpdateProfile.class);
        RestAssured.given(getRequestSpecifications()).filter(new AllureRestAssured())
                .basePath("users/profile")
                .body(reqBody).header("x-auth-token", "dc88e0b2845e4eaca0de7f7b9018e54289d62c85c7414fa68338afcbce0136c1")
                .patch()
                .then().spec(responseSpecification())
                .assertThat()
                .statusCode(200)
                .body("message", Matchers.equalTo("Profile updated successful"))
                .body("data.phone", Matchers.equalTo(phone))
                .body("data.company", Matchers.equalTo(company));
    }
}
