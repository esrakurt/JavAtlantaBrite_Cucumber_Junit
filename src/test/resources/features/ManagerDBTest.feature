#@db
Feature: BackEnd Testing

  #@wip
  Scenario: Verify if event types are duplicated in event_types table
    Given there is a list of events in event_types table
    And event types must be unique


  #@wip
  Scenario: verify if the Turkey in the countries table
    Given the country table in database
    And verify that table contains country Turkey

  @wip
  Scenario: BriteERP Application DB and UI verification
    Given I'm on Inventory Products Page
    When I search for "Peaches"
    And I query db with "SELECT * FROM product_template WHERE name = 'Peaches';"
    Then UI data and DB data must match