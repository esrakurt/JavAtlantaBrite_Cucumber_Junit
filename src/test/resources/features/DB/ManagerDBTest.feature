Feature: BackEnd Testing

  Background:
    Given I'm on Inventory Products Page

#  @db @4494
  Scenario: Verify if event types are duplicated in event_types table
    Given there is a list of events in event_types table
    And event types must be unique

#  @db @4495
  Scenario: verify if the Turkey in the countries table
    Given the country table in database
    And verify that table contains country Turkey

#  @uidb @4496
  Scenario Outline: BriteERP Application DB and UI verification
    When I search for "<product>"
    And I query db with "SELECT * FROM product_template WHERE name = '<product>';"
    Then UI data and DB data must match

    Examples:

      | product             |
      | Honda Accord        |
      | iPad Retina Display |
      | Tickets             |
      | Carrots             |

#  @uidb @4497
  Scenario: UI against DB verification when I entered new product
    When I insert a new "dictionary" and "15.00"
    And I query db with "SELECT * FROM product_template WHERE name = 'dictionary';"
    Then UI data and DB data must match




