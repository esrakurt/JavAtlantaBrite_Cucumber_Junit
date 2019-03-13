@wip
Feature: Employees

  Background:
    Given navigate to URL and select BriteErpDemo database
    And login with valid credentials


  Scenario: Employees name list test
    When Employees page open
    Then Employee names in UI match with Db records


  Scenario: Employees ID list check
    When Employees page open
    Then Employee IDs in DB records match with excel sheet