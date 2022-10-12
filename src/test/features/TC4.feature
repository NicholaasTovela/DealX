Feature: Performing a search on Automation Practice website
  Scenario Outline: log in using username and password
    Given User successfully navigates to the automation practice intent page
    And I click on the "sign in button"
    When I enter "<username>" and "<password>"
    And I click on the "log in button"

    Examples:
      | username                   | password     |
      | nicholaas.tovela@gmail.com | Password@123 |