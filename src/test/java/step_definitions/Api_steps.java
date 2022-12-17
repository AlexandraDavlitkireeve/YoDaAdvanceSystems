package step_definitions;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;



public class Api_steps {
    @Test
    public static void getId() {
        RestAssured.given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                //.prettyPeek()
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);
        System.out.println("Verified Content-Type Json successfully and status code");
    }
    }

