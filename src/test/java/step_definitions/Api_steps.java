package step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;
import java.util.List;
import static org.apache.http.HttpStatus.SC_OK;

public class Api_steps {

    Response response;

    final String BASEURI = ConfigReader.readProperty("BASE_URL");
    final String DEVCOURSE = ConfigReader.readProperty("dev");
    final String SDET = ConfigReader.readProperty("sdet");
    final String STUDENTDB = ConfigReader.readProperty("studentDb");
    String studentData;

    @Given("User gets Base URL")
    public void userGetsBaseURL() {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");
    }

    @When("User send GET request to the endpoint {string}")
    public void userSendGETRequestToTheEndpoint(String endpoint) {
        response = RestAssured.given()
                .when()
                .get(endpoint)
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

//    @Then("User sends request with username and password")
//    public void userSendsRequestWithUsernameAndPassword() {
//        String path = "/api/school/departments/gettoken";
//
//        response = RestAssured.given()
//                .auth().preemptive().basic("user", "user123")
//                .when()
//                .get(path)
//                .prettyPeek()
//                .then()
//                .statusCode(SC_OK)
//                .extract()// Method that extracts the response JSON DATA
//                .response();
//
//        Assert.assertEquals(SC_OK, response.statusCode());
//    }

    @When("User adds basic auth with username {string} and password {string}")
    public void userAddsBasicAuthWithUsernameAndPassword(String username, String password) {
        response = RestAssured.given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(ConfigReader.readProperty("token"))
                .prettyPeek()
                .then()
                .statusCode(SC_OK)
                .extract()// Method that extracts the response JSON DATA
                .response();

        Assert.assertEquals(SC_OK, response.statusCode());
    }


//    @Then("User send a POST request to the endpoint{string}")
//    public void userSendAPOSTRequestTheEndpoint(String strEndpoint, List<String> list)
//    {
//        response = RestAssured.given()
//                .header ("Content-Type" , "application/json")
//                .when()
//                .post(strEndpoint)
//                .then().log().all()
//                .extract()
//                .response();
//
//        System.out.println(response.jsonPath().getString("_id"));

//        for(int i =0; i < list.size(); i++)
//        {
//            Assert.assertNotNull(response.jsonPath().getString("data._id" + list.get(i) + "[0]"));
//
//        }
//    }

    @Then("User need an option to add new student to db. Following fields should be required to perform POST request")
    public void userNeedAnOptionToAddNewStudentToDbFollowingFieldsShouldBeRequiredToPerformPOSTRequest(List<String> list)
    {
        response = RestAssured.given()
                .header("Content-Type" , "application/json")
                .and()
                .post(STUDENTDB)
                .then()
                .log().all()
                .extract()
                .response();
        System.out.println("StudentDB" + list + response);
    }

//    @And("User should have option to add new student to db using following field")
//    public void userShouldHaveOptionToAddNewStudentToDbUsingFollowingField(List<String> list)
//    {
//        for(int i =0; i < list.size(); i++)
//        {
//            Assert.assertNotNull(response.jsonPath().getString("data." + list.get(i) + "[0]"));
//
//        }
//    }

}