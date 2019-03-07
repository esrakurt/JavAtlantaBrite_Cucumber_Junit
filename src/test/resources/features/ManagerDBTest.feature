#@db
Feature: BackEnd Testing

  @wip
  Scenario: Verify if event types are duplicated in event_types table
    Given there is a list of events in event_types table
    And event types must be unique


  @wip
  Scenario: verify if the Turkey in the countries table
    Given the country table in database
    And verify that table contains country Turkey


