#@wip
@smoke
Feature:

  Manager should be able to execute DB

  Background:
    Given user on the login page
    When user logs in using "manager"
    Then CRM module should be displayed

    Scenario: Kanban View Test
    And Manager should be able to see Kanban view

    Scenario: List View Test
    And Manager should be able to see List view

    Scenario: Pivot View Test
    And Manager should be able to see Pivot view

    Scenario: Calender Test
    And Manager should be able to see Calender

    Scenario: Graph View Test
    And Manager should be able to see Graph view


  Scenario Outline: Manager should be able to see different Graphs

    Then Manager should be display <graphs>

    Examples:
      | graphs           |
      | Days to Assign   |
      | Days to Close    |
      | Bounce           |
      | Probability      |
      | Expected Revenue |