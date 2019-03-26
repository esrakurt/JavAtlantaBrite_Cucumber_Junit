#@xl
Feature: Event Type
  Background:
    Given user on the login page
    When user logs in using "manager"
    Then Event module should be displayed

  Scenario: Event creating with Excel file

    When user create events
    Then user should use Event_Type Excel file


