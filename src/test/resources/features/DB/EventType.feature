
Feature: Event Type  in DataBase

  Background:
    Given user on the login page
    When user logs in using "manager"
    Then Event module should be displayed


  Scenario Outline:  Event Type <option>

    And Below data should match in DB Event Type -"<option>"

    Examples:
      | option         |
      | Seminar        |
      | Exhibition     |
      | Physical Event |



  Scenario: UI DB compare

    When Event Categories page open
    Then UI data match with Db values

  @db

  Scenario: Excel-DB values compare

    When user create events
    Then user should use Event_Type Excel file
    Then DB vslues should match with Excel File


