Feature: Add an item to cart on ampeg site

  Scenario: Validate if user can add SVT Suite to Cart
    Given user is on the home page
    When user clicks the shop button
    And user clicks the software button
    And user clicks add to cart 
    Then AVT Suite should be added to cart