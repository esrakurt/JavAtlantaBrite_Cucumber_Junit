<<<<<<< HEAD

=======
>>>>>>> master
Feature: login functionality

  Scenario: user login
    Given user on the login page
    When user logs in using "manager"
    Then CRM module should be displayed
