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
      | "_id"      |
      | "name"     |
      | "duration" |

  @ASY-22
  Scenario Outline: Add new course to db
    When User adds basic auth with username "user" and password "user123"
    Then User adds new "<name>" and "<duration>" to the endpoint "/api/school/programs/devcourse"
    And User adds new "<name>" and "<duration>" to the endpoint "/api/school/programs/sdetcourse"
    And User should get status code 200

    Examples:
      | name       | duration |
      | API Expert | 2 months |

  @ASY-27
  Scenario: Bearer token retrieval
    When User adds basic auth with username "user" and password "user123"
    Then User should get status code 200
#    And User send GET request to the endpoint "/api/school/departments/gettoken"
    Then response should contain a "token"


  @ASY-27a
  Scenario: Bearer token retrieval
    When User adds basic auth with username "users" and password "user1234"
    Then User should get status code 401
#    And User send GET request to the endpoint "/api/school/departments/gettoken"
    Then response should contain a message "Invalid username or password"
