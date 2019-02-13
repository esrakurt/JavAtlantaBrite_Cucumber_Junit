@wip
Feature: login functionality

  Scenario: user login
    Given user on the login page
    When user logs in using "user"
    Then CRM module should be displayed
