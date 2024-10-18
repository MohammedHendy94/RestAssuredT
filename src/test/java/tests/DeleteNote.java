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

public class DeleteNote extends BaseTest {


    @Story("Delete Notes")
    @Description("Delete a note and verify it’s deleted successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "delete a note")
    public void validateThatNoteDeletedSuccessfully(){
        RestAssured.given(getRequestSpecifications()).filter(new AllureRestAssured())
                .basePath("notes").pathParam("id","6712b7f72b47f201538b688b")
                .header("x-auth-token", "dc88e0b2845e4eaca0de7f7b9018e54289d62c85c7414fa68338afcbce0136c1")
                .delete("{id}")
                .then().spec(responseSpecification())
                .assertThat()
                .statusCode(200)
                .body("message", Matchers.equalTo("Note successfully deleted"));
    }

}
