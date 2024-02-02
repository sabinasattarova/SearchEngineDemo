@us04 @ui
Feature: Search functionality across different search engines
  User Story: As a user when I am on the Google, Yahoo search pages
  I should be able to search anything and see relevant error message

  @ts07
  Scenario Outline:Negative Testing Yahoo page
    Given user is on the "google" page
    When user searches for "<random>" data in google
    Then user should see "<error>" message in the result in google page
    Examples:
      | random          | error                        |
      | @{faker.random} | We did not find results for: |
      | @{faker.random} | We did not find results for: |