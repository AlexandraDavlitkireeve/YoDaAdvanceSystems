Feature: End to end test

  Background: URL
    Given Navigate to URL

  @ASY-21
  Scenario: GET existing courses
    When I send GET request to the "endpoint"
  Then the response should include a field called "id"
  And  the response should include a field called "name"
  And  the response should include a field called "duration"


