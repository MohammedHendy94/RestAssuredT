package tests;

import bases.BaseTest;
import com.jayway.jsonpath.JsonPath;
import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestRestPost extends BaseTest {

    @Test
    public void postStatusCode(){
        JSONObject object1 = new JSONObject();
        object1.put("title" , "coora");

        given()
                .contentType(ContentType.JSON)
                .baseUri("https://dummyjson.com/products/add").log().all()
                .body(object1.toString())
             .post()
                .then().log().all().assertThat()
                .statusCode(200).log();
    }



















}
