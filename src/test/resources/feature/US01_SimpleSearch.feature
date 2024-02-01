@ui @us01
Feature: Search functionality across different search engines
  User Story: As a user when I am on the Google, Bing, Yahoo search pages
  I should be able to search anything and see relevant results

  @ts01
  Scenario: Search functionality testing with Parameterization
    Given user is on the "searchEngine" search page
    When user searches for "Orange"
    Then first returned item must contain "Orange"
    And title name must contain "Orange"

  @ts02
  Scenario Outline: Search functionality testing with Scenario Outline
    Given user is on the "searchEngine" search page
    When user searches for "<subject>"
    Then first returned item must contain "<subject>"
    And title name must contain "<subject>"
    Examples:
      | subject          |
      | Math             |
      | Geometry         |
      | Biology          |
      | Chemistry        |
      | Computer Science |
