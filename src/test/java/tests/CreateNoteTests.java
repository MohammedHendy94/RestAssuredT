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
import readData.ReadTestData;

import java.io.IOException;

public class CreateNoteTests extends BaseTest {

    CreatNote creatNote;
    @DataProvider
    public String[][] createNoteTestData() throws IOException, InvalidFormatException {
        ReadTestData reedClientData = new ReadTestData();
        return reedClientData.readNotesTestdata();
    }

    @Story("Create Notes")
    @Description("Create a note and verify it’s added to the list of all notes")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider ="createNoteTestData",description = "create a note")
    public void validateThatNewNoteCreatedSuccessfully( String title, String description, String category) throws JsonProcessingException {
        creatNote = new CreatNote(title, description, category);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(creatNote);
        creatNote = objectMapper.readValue(reqBody, CreatNote.class);
        RestAssured.given(getRequestSpecifications()).filter(new AllureRestAssured())
                .basePath("notes")
                .body(reqBody).header("x-auth-token", "dc88e0b2845e4eaca0de7f7b9018e54289d62c85c7414fa68338afcbce0136c1")
                .post()
                .then().spec(responseSpecification())
                .assertThat()
                .statusCode(200)
                .body("message", Matchers.equalTo("Note successfully created"));
    }
}
