package step_definitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import static org.apache.http.HttpStatus.*;

public class Api_steps {
    private static final String BASE_URL = "https://tla-school-api.herokuapp.com";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "user123";

     Response response;


    Map<String, Object> variables;

    String id;
    String name;
    String duration;


    @Given("User gets Base URL")
    public void userGetsBaseURL() {
        RestAssured.baseURI = BASE_URL;
    }
    @When("User send GET request to the endpoint")
    public void userSendGETRequestToTheEndpoint()  {
        String path = "/api/school/programs/devcourse";
        String path2 = "/api/school/programs/sdetcourse";
//        String requestBody = "{\"_id\":\""+variables.get("_id")+"\",\"name\":\""+variables.get("name")+"\",\"duration\":\""+variables.get("duration")+"\",\"__v\":0}}}}}";
//        System.out.println(requestBody);
//        System.out.println(variables.get("_id"));
//        System.out.println(variables.get("name"));
//        System.out.println(variables.get("duration"));
        response = RestAssured.given()
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();
        Assert.assertEquals("_id", "_id");

        response = RestAssured.given()
                .when()
                .get(path2)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        variables = new HashMap<>();
        variables.put("_id", id);
        variables.put("duration", duration);
        variables.put("name", name);
    }

    @Given("User sends request with username and password")
    public void userSendsRequestWithUsernameAndPassword() {
        String path = "/api/school/departments/gettoken";

        Map<String, Object> map = new HashMap<>();
        map.put("username", "user");
        map.put("password", "user123");

        response = RestAssured.given()
                .queryParams(map)
                .when()
                .get(path)
                .prettyPeek()
                .then()
                .statusCode(SC_OK)
                .extract()// Method that extracts the response JSON DATA
                .body()// Body extracted as a JSON format
                .jsonPath()// Navigate using jsonPath
                .get("token"); // Get a value as a key token

        Assert.assertEquals(SC_OK, response.statusCode());

    }

}
