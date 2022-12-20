package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class Api_steps {

    private static final String path = "/api/school/programs/devcourse";
    private static final String path2 = "/api/school/programs/sdetcourse";
    private static final String path3 = "/api/school/resources/students";

    Response response;

    @Given("User gets Base URL")
    public void userGetsBaseURL() {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");
    }

    @When("User send GET request to the endpoint {string}")
    public void userSendGETRequestToTheEndpoint(String endpoint) {
        response = given()
                .when()
                .get(path)
                .then()
                .log().all()
                .extract()
                .response();
    }
    @Then("User should get status code {int}")
    public void userShouldGetStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }
    @Then("the response should include fields called {string}, {string} and {string}")
    public void theResponseShouldIncludeFieldsCalledAnd(String field1, String field2, String field3) {
        Assert.assertNotNull(response.jsonPath().getString("data." + field1 + "[0]"));
        Assert.assertNotNull(response.jsonPath().getString("data." + field2 + "[0]"));
        Assert.assertNotNull(response.jsonPath().getString("data." + field3 + "[0]"));
    }

    @Then("the response should include following fields")
    public void theResponseShouldIncludeFollowingFields(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            Assert.assertNotNull(response.jsonPath().getString("data." + list.get(i) + "[0]"));
        }
    }

    @Then("User sends request with username and password")
    public void userSendsRequestWithUsernameAndPassword() {
        String path = "/api/school/departments/gettoken";

        response = given()
                .auth().preemptive().basic("user", "user123")
                .when()
                .get(path)
                .prettyPeek()
                .then()
                .statusCode(SC_OK)
                .extract()// Method that extracts the response JSON DATA
                .response();

        Assert.assertEquals(SC_OK, response.statusCode());
    }
    @Then("Create option to add new student to db using the following id parameter")
    public void createOptionToAddNewStudentToDbUsingTheFollowingIdParameter(List list)
    {

        response = given()
                .when()
                .post(path)
                .then().log().all()
                .extract()
                .response();

    }
}



