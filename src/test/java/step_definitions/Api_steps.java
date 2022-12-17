package step_definitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class Api_steps {
    private static final String BASE_URL = "https://tla-school-api.herokuapp.com";

    private static String token;
    private static Response response;

    Map<String, Object> variables;

    String id;
    String name;
    String duration;

    @Given("Verify a list of existing {string} course")
    public void verify_a_list_of_existing_course(String sdet) {
        RestAssured.baseURI = BASE_URL;
        String path = "/api/school/programs/sdetcourse";

        response = RestAssured.given()
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();
        System.out.println(id);
        //Assert.assertEquals(id, response.jsonPath().getString("_id"));
        Assert.assertTrue(id.contains("_id"));

        variables = new HashMap<>();
        variables.put("_id", id);
        variables.put("duration", duration);
        variables.put("name", name);
    }
}
