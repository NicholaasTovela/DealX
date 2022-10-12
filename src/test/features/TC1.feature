Feature: Performing a search on Automation Practice website
  Scenario Outline: verify if first result matches search result
    Given User successfully navigates to the automation practice intent page
    And I click on the "search box"
    When I enter "<Item>" in the searchbox
    And I click on the "search button"
    Then I verify if the first result matches search "<Item>"

    Examples:
      | Item       |
      | Printed Summer Dress  |