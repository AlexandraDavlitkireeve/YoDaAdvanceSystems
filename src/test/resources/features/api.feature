Feature: End to end test

  Background: URL
    Given User gets Base URL

  @ASY-21
  Scenario: GET existing courses
    When User send GET request to the endpoint "/programs/devcourse"
    Then User should get status code 200
    When User send GET request to the endpoint "/programs/sdetcourse"
    Then User should get status code 200
#    Then the response should include fields called "_id", "name" and "duration"
    Then the response should include following fields
      | "_id"       |
      | "name"     |
      | "duration" |

 @ASY-24
   Scenario: Add new student
   When User send POST request to endpoint "/api/school/resources/students"
   Then There should be an option to add new student to db in the following fields
     | "batch name" |
     | "firstname"  |
     | "lastname"   |
     | "email"      |


  @ASY-27
  Scenario: Bearer token retrieval
    When User adds basic auth with username "user" and password "user123"
    And User send GET request to the endpoint "/departments/gettoken"
    Then response should contain a token
    Then response should contain a message "Invalid username or password"


