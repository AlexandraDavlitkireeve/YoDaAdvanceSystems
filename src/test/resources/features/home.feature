Feature: Home Page Test

  Background: Home page
    Given Navigate to Home page

  @ASY-1  @regression
  Scenario: HomePage


  @ASY-3 @smoke @regression
  Scenario: Contact info on main page
    Then verify 10090 Main Street is displayed
    And Verify Fairfax, VA, USA is displayed
    And Verify Phone: "703-831-3217" is displayed

  @ASY-4 @smoke @regression
  Scenario: Parallax section
    Then header is displayed
    And verify description is displayed
    And verify read more button is displayed

  @ASY-6 @smoke @regression
  Scenario: Title of the home page
    Then Verify Title of the homepage should be "Advance Systems - Home"

  @ASY-7 @smoke @regression
  Scenario Outline: General navigation bar
    Then Verify button "<nav button>" is displayed
    Then Verify "<language>" selection

    Examples:
      | language | nav button  |
      | English  | Get Support |
      | Spanish  | Job Career  |
      | French   | Feedback    |


  @ASY-8 @smoke @regression
  Scenario Outline: Main social media section
    Then Verify button "<nav button>" is clickable
    Examples:
      | nav button |
      | facebook   |
      | twitter    |
      | instagram  |
      | linkedin   |

  @ASY-9 @smoke @regression
  Scenario Outline: Page navigation bar
    When Verify main navigation bar
    Then Verify each button click after scroll "<navButton>"
    Then Verify page navigation bar has correct title "<title>"
    Examples:
      | navButton  | title                        |
      | Home       | Advance Systems - Home       |
      | About Us   | Advance Systems - About Us   |
      | Services   | Advance Systems - Services   |
      | Clients    | Advance Systems - Clients    |
      | Join Us    | Advance Systems - Join Us    |
      | Contact Us | Advance Systems - Contact Us |

  @ASY-10 @smoke @regression
  Scenario: Main call to cation button
    Then Verify "Join Now" button above the main content of the home page
    And Verify button should take the user to "Join Us" page

  @ASY-11 @smoke @regression
  Scenario: What to expect section
    Then Verify items are displayed as a header and description under it


  @ASY-12 @smoke @regression
  Scenario: Testimonials
    Then Verify header "Words from our Clients" is Displayed
    Then Verify testimonials, person's name and city are displayed

  @ASY-13 @smoke @regression
  Scenario: List of companies
    Then Verify Company  names are  display in one row


  @ASY-14 @smoke
  Scenario Outline: Footer contact info

    Then Verify "<contact info>" is displayed
    Examples:
      | contact info                        |
      | Address: 10090 Main St, Fairfax, VA |
      | Phone: +1 703-831-3217              |
      | Email: info@advancesystems.us       |
      | Mon to Sat: 9.00 am to 5:00 pm      |

  @ASY-15 @smoke @regression
  Scenario Outline: Footer quick links
    And Verify links "<footer links>" are displayed
    And Verify links "<footer links>" are clickable
    And Verify links "<footer links>" are opening corrisponding page
    Examples:
      | footer links |
      | Home         |
      | About Us     |
      | Services     |
      | Clients      |
      | Join Us      |
      | Contact Us   |


  @ASY-16 @smoke @regression
  Scenario Outline: Test footer social media links are displayed
    Then Verify  "<social media>" buttons are displayed
    Examples:
      | social media |
      | facebook     |
      | twitter      |
      | skype        |
      | linkedin     |