package tests;

import bases.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojos.ClientInfo;
import readData.ReadTestData;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RegisterClientAPITests extends BaseTest {
    ClientInfo clientInfo;
    @DataProvider
    public String[][] clientTestData() throws IOException, InvalidFormatException {
        ReadTestData reedClientData = new ReadTestData();
        return reedClientData.readdata();
    }

    @Test(dataProvider ="clientTestData")
    public void validateThatClientCanBeCreated(String name, String email) throws JsonProcessingException {
        //#1 Serialization
        clientInfo = new ClientInfo(name,email);

        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientInfo);
        System.out.println(reqBody);

        //#1 De-Serialization
        clientInfo = objectMapper.readValue(reqBody,ClientInfo.class);
        System.out.println(clientInfo.getClientEmail()+"  "+clientInfo.getClientName());

        //make a post request
        Response response =
        RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri("https://simple-books-api.glitch.me/api-clients")
                .body(reqBody)
                .post()
                .then().assertThat()
                .statusCode(201).extract().response();
        String token = response.path("accessToken");
      String res =  response.getBody().asString();
        System.out.println("the token is "+ token + "and all response is "+ res);

    }









}
