@us04 @ui
Feature: Search functionality across different search engines
  User Story: As a user when I am on the Google, Yahoo search pages
  I should be able to search anything and see relevant error message

  @ts07
  Scenario Outline:Faker Negative Testing Google page
    Given user is on the "google" page
    When user searches for "<random>" data in "google"
    Then user should see "<error>" message in the result in "google" page
    Examples:
      | random  | error                                               |
      | random1 | Your search - random - did not match any documents. |
      | random2 | Your search - random - did not match any documents. |

  @ts08
  Scenario Outline:Faker Negative Testing Yahoo page
    Given user is on the "yahoo" page
    When user searches for "<random>" data in "yahoo"
    Then user should see "<error>" message in the result in "yahoo" page
    Examples:
      | random  | error                                |
      | random1 | We did not find results for: random. |
      | random2 | We did not find results for: random. |