Feature: End to end test

  Background: URL
    Given User gets Base URL

  @ASY-27
  Scenario: Bearer token retrieval
  Given User sends request with username and password


  @ASY-21
  Scenario: GET existing courses
    When User send GET request to the endpoint
#  Then the response should include a field called "id"
#  And  the response should include a field called "duration"
#  And  the response should include a field called "name"


