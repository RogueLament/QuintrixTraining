Feature: Search Ampeg products

  Scenario: Validate if user can find item with exact name
    Given user is on the home page
    When user clicks the search button
    And user searches "HERITAGE 50TH ANNIVERSARY SVT"
    And user clicks first result
    Then HERITAGE 50TH ANNIVERSARY SVT should be displayed

  Scenario: Validate if user can find item with vague search
    Given user is on the home page
    When user clicks the search button
    And user searches "software"
    And user clicks first result
    Then software page should be displayed
    When user goes back
    And user clicks second result
    Then software page should be displayed
    When user goes back
    And user clicks third result
    Then plug-ins page should be displayed
    