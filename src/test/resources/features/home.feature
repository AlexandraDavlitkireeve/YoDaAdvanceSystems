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

  @ASY-6 @smoke
  Scenario: Title of the home page
    Then Verify Title of the homepage should be "Advance Systems - Home"

  @ASY-7 @smoke
  Scenario Outline: General navigation bar
    Then Verify button "<nav button>" is displayed
    Examples:
      | nav button         |
      | Get Support        |
      | Job Career         |
      | Feedback           |
      | Language selection |
      | English            |
      | Spanish            |
      | French             |

  @ASY-4
  Scenario: Parallax section
    Then header is displayed
    And verify description is displayed
    And verify read more button is displayed

  @ASY-14 @smoke
  Scenario: Footer contact info
    Then verify Following information footer section is displayed




