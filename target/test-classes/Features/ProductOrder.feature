Feature: Product wishlist and cart functionality

  @TestID-001
  Scenario: To verify product wishlist and cart functionality
    Given I add four different products to my wish list
      |Oldies|
      |Hard top|
      |Modern|
      |Evening trousers|
    When  I view my wishlist table
    Then  I find total four selected items in my Wishlist
    When  I search for lowest price product
    And   I am able to add the lowest price item to my cart
    Then  I am able to verify the item in my cart