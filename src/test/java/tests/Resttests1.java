import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Resttests1 {

    @Test
    public void TestStatusCode(){
        given().get("https://dummyjson.com/products/1")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void TestRespons(){
       Response resp = RestAssured.get("https://dummyjson.com/products/1");
        Assert.assertEquals(resp.statusCode(),200);
    }
    @Test
    public void TestBody(){
        given().get("https://dummyjson.com/products/1")
                .then().assertThat().body("title", equalTo("iPhone 9")).
                and().body("price",equalTo(549));

    }




}
