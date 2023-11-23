package tests;

import bases.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import listener.Listeners;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojos.ClientInfo;
import readData.ReadTestData;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static io.restassured.RestAssured.given;

public class RegisterClientAPITests extends BaseTest {
    ClientInfo clientInfo;

    @DataProvider
    public String[][] clientTestData() throws IOException, InvalidFormatException {
        ReadTestData reedClientData = new ReadTestData();
        return reedClientData.readdata();
    }

    // normal test case with the common detailed stpes
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

    //the test case after enhancing request repeated steps into test base
    @Test(dataProvider ="clientTestData")
    public void enhancedValidateThatClientCanBeCreated(String name, String email) throws JsonProcessingException {
        //#1 Serialization
        clientInfo = new ClientInfo(name,email);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientInfo);
        System.out.println(reqBody);

        //#1 De-Serialization
        clientInfo = objectMapper.readValue(reqBody,ClientInfo.class);
        System.out.println(clientInfo.getClientEmail()+"  "+clientInfo.getClientName());

        //make a post request
        ClientInfo response =
                RestAssured.given(getRequestSpecifcations())
                        .basePath("/api-clients")
                        .body(reqBody)
                        .post()
                        .then().spec(responseSpecification())
                        .assertThat()
                        .statusCode(201).extract().as(ClientInfo.class);
        Assert.assertTrue(response.getAccessToken() != null);
    }

    @Test(dataProvider ="clientTestData")
    public void mostEnhancedValidateThatClientCanBeCreated(String name, String email) throws JsonProcessingException {

        clientInfo = new ClientInfo(name,email);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientInfo);
        clientInfo = objectMapper.readValue(reqBody,ClientInfo.class);
        ClientInfo response =
                    RestAssured.given(getRequestSpecifcations()).filter(new Listeners())
                        .basePath("/api-clients")
                        .body(reqBody)
                        .post()
                        .then().spec(responseSpecification())
                        .assertThat()
                        .statusCode(201).extract().as(ClientInfo.class);
        Assert.assertNotNull(response.getAccessToken());

    }





}
