Feature: End to end test

  Background: URL
    Given User gets Base URL

  @ASY-21
  Scenario: GET existing courses
    When User send GET request to the endpoint "/api/school/programs/devcourse"
    Then User should get status code 200
    When User send GET request to the endpoint "/api/school/programs/sdetcourse"
    Then User should get status code 200
#    Then the response should include fields called "_id", "name" and "duration"
    Then the response should include following fields
      | "_id"       |
      | "name"     |
      | "duration" |

  @ASY-24
  Scenario: Add new student
    Then User need an option to add new student to db. Following fields should be required to perform POST request
      | "batch name" |
      | "firstname"  |
      | "lastname"   |
      | "email"      |


#    Scenario: Add new student
#    Then User send a POST request to the endpoint"/api/school/resources/students"
#   And User should have option to add new student to db using following field
#      | "batch name" |
#      | "firstname"  |
#      | "lastname"   |
#      | "email"      |

  @ASY-27
  Scenario: Bearer token retrieval
    When User adds basic auth with username "user" and password "user123"
    And User send GET request to the endpoint "/departments/gettoken"
    Then response should contain a token
    Then response should contain a message "Invalid username or password"
