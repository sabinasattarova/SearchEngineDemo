@us02 @ui
Feature: Search functionality across different search engines
  User Story: As a user when I am on the Google, Yahoo search pages
  I should be able to search anything and see relevant results

  Background: For all scenarios user is on the Google search page
    Given user is on the "searchEngine" search page

  @ts03
  Scenario Outline: Search functionality testing with Scenario Outline
    When user searches for "<country>" capital
    Then user should see "<capital>" in the result
    Examples:
      | country    | capital          |
      | USA        | Washington, D.C. |
      | Uzbekistan | Tashkent         |
      | Russia     | Moscow           |
      | UAE        | Abu Dhabi        |
      | Turkey     | Ankara           |


  @ts04
  Scenario Outline: Search functionality testing Calculations
    When user searches for "<data>"
    Then first returned item must be result of calculation "<expectedResult>"
    And title name must contain "<data>"
    Examples:
      | data       | expectedResult |
      | 15% of 100 | 15             |
      | 25% of 100 | 25             |