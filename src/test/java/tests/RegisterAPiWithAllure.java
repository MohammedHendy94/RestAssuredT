package tests;

import bases.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import listener.Listeners;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojos.ClientInfo;
import readData.ReadTestData;

import java.io.IOException;


@Epic("allure report check")
@Feature("API Registeration")
public class RegisterAPiWithAllure extends BaseTest {

    ClientInfo clientInfo;

    @DataProvider
    public String[][] clientTestData() throws IOException, InvalidFormatException {
        ReadTestData reedClientData = new ReadTestData();
        return reedClientData.readdata();
    }

    @Story("Client Registerartion")
    @Description("trying the allure report in my automation")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider ="clientTestData",description = "API Client register")
    public void mostEnhancedValidateThatClientCanBeCreated(String name, String email) throws JsonProcessingException {

        clientInfo = new ClientInfo(name,email);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientInfo);
        clientInfo = objectMapper.readValue(reqBody,ClientInfo.class);
        Response response =
                RestAssured.given(getRequestSpecifcations()).filter(new AllureRestAssured())
                        .basePath("/api-clients")
                        .body(reqBody)
                        .post()
                        .then()
                        .assertThat()
                        .statusCode(201).extract().response();
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().asString());
    }
}
