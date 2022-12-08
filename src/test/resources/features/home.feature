Feature: Home Page Test
  Background: Home page
    Given Navigate to Home page
  @ASY-1
  Scenario: HomePage


  @ASY-3 @smoke
  Scenario: Contact info on main page
    Then verify 10090 Main Street is displayed
    And Verify Fairfax, VA, USA is displayed
    And Verify Phone: "703-831-3217" is displayed


git s