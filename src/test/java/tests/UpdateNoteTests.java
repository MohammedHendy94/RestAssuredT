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
import pojos.CreatNote;
import pojos.UpdateNote;
import readData.ReadTestData;

import java.io.IOException;

public class UpdateNoteTests extends BaseTest {


    UpdateNote updateNote;

    @DataProvider
    public String[][] updateNoteTestData() throws IOException, InvalidFormatException {
        ReadTestData reedClientData = new ReadTestData();
        return reedClientData.readUpdateNotesTestdata();
    }

    @Story("Update Notes")
    @Description("Update a note and verify it’s updated successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider ="updateNoteTestData",description = "update a note")
    public void validateThatNoteUpdatedSuccessfully(String title, String description, String completed, String category) throws JsonProcessingException {
        updateNote = new UpdateNote(title, description, completed, category);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(updateNote);
        updateNote = objectMapper.readValue(reqBody, UpdateNote.class);
        RestAssured.given(getRequestSpecifications()).filter(new AllureRestAssured())
                .basePath("notes").pathParam("id","67129e872b47f201538b681a")
                .body(reqBody).header("x-auth-token", "dc88e0b2845e4eaca0de7f7b9018e54289d62c85c7414fa68338afcbce0136c1")
                .put("{id}")
                .then().spec(responseSpecification())
                .assertThat()
                .statusCode(200)
                .body("message", Matchers.equalTo("Note successfully Updated"));
    }
}
