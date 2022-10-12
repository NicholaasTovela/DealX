Feature: Performing a search on Automation Practice website
  Scenario Outline: add item to cart and verify total
    Given User successfully navigates to the automation practice intent page
    And I click on the "sign in button"
    When I enter "<username>" and "<password>"
    And I click on the "log in button"
    Then I enter "blouse" in the searchbox
    And I click on the "search button"

    When I add and view an item in cart
    And I increase the cart quantity by "2"
    Then I calculate total and verify it with the total on the cart

    Examples:
      | username                   | password     |
      | nicholaas.tovela@gmail.com | Password@123 |