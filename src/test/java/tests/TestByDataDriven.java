package tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import readData.ReadTestData;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class TestByDataDriven {
    @DataProvider
    public String[][] testdata() throws IOException, InvalidFormatException {
        ReadTestData reed = new ReadTestData();
        return reed.readdata();
    }

    @Test (dataProvider = "testdata")
    public void testdriven (String id, String title) {
        String respons = RestAssured.get("https://dummyjson.com/products/"+id).andReturn().asString();
        Assert.assertTrue(respons.contains(id));
        Assert.assertTrue(respons.contains(title));
    }
    @Test (dataProvider = "testdata")
    public void restinvaliddriven(String id, String title){
        String respons = RestAssured.get("https://dummyjson.com/products/"+id).asString();
        System.out.println(respons);
        Assert.assertTrue(respons.contains("not found"));

    }



}
