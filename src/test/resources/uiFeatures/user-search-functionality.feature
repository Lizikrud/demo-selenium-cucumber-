@regression
Feature: User Search Functionality

  @bookClubs
  Scenario Outline: Search a product
    Given User landing on search page of web-application
    When user enters "<text>" in search box
    @kidsBooks
    Examples:
      | text                                                 |
      | Dragons Love Tacos                                   |
#            | Bluey 5-Minute Stories: 6 Stories in 1 Book? Hooray! |
#            | Fox in Socks