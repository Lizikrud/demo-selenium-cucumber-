Feature: Login Functionality
  @validCredentials
  Scenario: Login with valid credentials
    Given User navigates to web-application
    When User click on SIGN IN button and transfer to signin page
    Then User logs in with EMAIL "yulliaroberts123@gmail.com" and PASSWORD "yr123456789"
    And  User clicks on LOG IN button
    Then User is redirected to account page
  @invalidCredentials
  Scenario: Login with invalid credentials
    Given User navigates to web-application
    When User click on SIGN IN button and transfer to signin page
    Then User logs in with invalid EMAIL and invalid PASSWORD
    And  User clicks on LOG IN button
    Then User see error message