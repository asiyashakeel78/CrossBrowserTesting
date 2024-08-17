Feature: check login functionality 

  Scenario Outline: successful login with valid credentials
    Given user is on the log in page for "<browser>"
    When user enters valid username and password
    And user click on the login button
    Then user is navigated to the dashboard
    
  Examples:
    | browser  |
    | chrome   |
    | edge     |
    | firefox  |
 

  