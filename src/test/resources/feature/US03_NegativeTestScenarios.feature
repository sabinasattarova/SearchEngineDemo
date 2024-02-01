@us03 @ui
Feature: Search functionality across different search engines
  User Story: As a user when I am on the Google, Bing, Yahoo search pages
  I should be able to search anything and see relevant error message


  @ts05
  Scenario Outline: Negative Testing Google page
    Given user is on the "google" page
    When user searches for "<random>" data
    Then user should see "<error>" message in the result in google
    Examples:
      | random             | error                                                           |
      | 837692623875       | Your search - 837692623875 - did not match any documents.       |
      | jkabgJKbnejkbn     | No results containing all your search terms were found.         |
      | hfteuigha'gheu68#$ | Your search - hfteuigha'gheu68#$ - did not match any documents. |


  @ts06
  Scenario Outline: Negative Testing Yahoo page
    Given user is on the "yahoo" page
    When user searches for "<random>" data
    Then user should see "<error>" message in the result in yahoo
    Examples:
      | random         | error                                        |
      | 837692623875   | We did not find results for: 837692623875.   |
      | jkabgJKbnejkbn | We did not find results for: jkabgJKbnejkbn. |