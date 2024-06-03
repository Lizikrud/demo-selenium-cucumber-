Feature: Account Functionality

  Background:
    Given User landing on Profile page

  @usernameValidation
  Scenario: Validate User profile with provided username
    Then  User can see username "YULLIAROBERTS123" on profile dropdown button

  @profileDropdownValidation
  Scenario: User validate profile dropdown
    When User click on username profile
    Then User see list of dropdown