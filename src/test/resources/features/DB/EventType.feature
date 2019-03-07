
Feature: Event Type  in DataBase

  Background:
    Given user on the login page
    When user logs in using "manager"
    Then Event module should be displayed
  @db
  Scenario: UI DB compare

    And UI data match with Db values

  Scenario Outline:  Event Type <option>

    And Below data should match in DB Event Type -"<option>"

    Examples:
      | option          |
      | Seminarerere    |
      | Exhibition      |
      | Physical Event  |
