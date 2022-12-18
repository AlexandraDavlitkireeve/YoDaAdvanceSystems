package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.BrowserUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class Api_steps {
    private static final String BASE_URL = "https://tla-school-api.herokuapp.com";

    private static String token;
    private static Response response;

    Map<String, Object> variables;

    String id;
    String name;
    String duration;

//    @Given("Verify a list of existing {string} course")
//    public void verify_a_list_of_existing_course(String sdet) {
//        RestAssured.baseURI = BASE_URL;
//        String path = "/api/school/programs/sdetcourse";
//
//        response = RestAssured.given()
//                .when()
//                .get(path)
//                .then()
//                .statusCode(200)
//                .log().all()
//                .extract()
//                .response();
//        System.out.println(id);
//        //Assert.assertEquals(id, response.jsonPath().getString("_id"));
//        Assert.assertTrue(id.contains("_id"));
//
//        variables = new HashMap<>();
//        variables.put("_id", id);
//        variables.put("duration", duration);
//        variables.put("name", name);
//    }

    @Given("Navigate to URL")
    public void navigateToURL() {
        BrowserUtils.getDriver().get(BASE_URL);
    }

    @When("I send GET request to the {string}")
    public void iSendGETRequestToThe(String endPoint) {
        RequestSpecification request = RestAssured.given().baseUri(endPoint);
        response = request.when().get();
        System.out.println(response);
    }
//    @When("I send GET request to the endpoint")
//    public void iSendGETRequestToTheEndpoint() {
//        RestAssured.baseURI = BASE_URL;
//        String path = "/api/school/programs/sdetcourse";
//        response = RestAssured.given()
//                .when()
//                .get(path)
//                .then()
//                .statusCode(200)
//                .log().all()
//                .extract()
//                .response();
//        System.out.println(variables.get(id));
//    }

    @Then("the response should include a field called {string}")
    public void theResponseShouldIncludeAFieldCalled(String course) {

    }

}
