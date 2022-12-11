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

  @ASY-4
  Scenario: Parallax section
    Then header is displayed
    And verify description is displayed
    And verify read more button is displayed

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


  @ASY-8 @smoke
  Scenario Outline: Main social media section
    Then Verify button "<nav button>" is clickable
    Examples:
      | nav button |
      | Facebook   |
      | Twitter    |
      | Google     |
      | LinkedIn   |

  @ASY-9 @smoke
  Scenario Outline: Page navigation bar
    Then Verify main navigation bar
    And Verify secondary Navigation bar is visible after scroll
    And Verify button "<nav button>" take the user to corresponding page when click
    Examples:
      | nav button |
      | Home       |
      | About Us   |
      | Services   |
      | Clients    |
      | Join Us    |
      | Contact Us |

  @ASY-10 @smoke
  Scenario: Main call to cation button
    Then Verify "Join Now" button above the main content of the home page
    And Verify button should take the user to "Join Us" page


  @ASY-12
  Scenario: Testimonials
    Then Verify header "Words from our Clients" is Displayed
    Then Verify testimonials, person's name and city are displayed

  @ASY-13 @smoke
  Scenario: List of companies
    Then Verify Company  names are  display in one row

  @ASY-14 @smoke
  Scenario Outline:: Footer contact info
    Then Verify "<contact info>" is displayed
    Examples:
      | contact info                          |
      | Address: 10090 Main St, Fairfax, VA   |
      | Phone: +1 703-831-3217                |
      | Email: info@advancesystems.us         |
      | Mon to Sat: 9.00 am to 5:00 pm        |

  @ASY-16 @smoke
  Scenario Outline: Test footer social media links are displayed
    Then Verify  "<social media>" buttons are displayed
    Examples:
      | social media |
      | facebook     |
      | twitter      |
      | skype        |
      | linkedin     |













