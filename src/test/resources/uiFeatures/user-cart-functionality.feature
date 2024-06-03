Feature: Add item to the cart functionality

  @addItem
  Scenario: Add book to cart
    Given User landing on book page
    When  User click on "Lessons in Chemistry: A Novel"
    Then  User redirected to that book page "https://bookclubs.com/books/lessons-in-chemistry-a-novel-137422"
    When  User click on BOOKSHOP button
    Then  User transfer to new tab with option add to cart
    And   Click on ADD TO CART button
    Then  User see pop-up window with option Keep Shopping and Checkout Out
    When  User click on CHECKOUT button
    Then  User redirected to Cart Page and see book in cart