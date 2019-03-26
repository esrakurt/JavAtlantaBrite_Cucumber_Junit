Feature: Excel Testing

  Background:

#  @xl
  Scenario: Verify if event types are duplicated in event_types table
    Given a list of quotations specifications
    And return all specification on xls sheet
    Then verify that spreadsheet contains "SalesPerson"


  @xl
  Scenario: Different products entered through UI should be seen in DB
    Given the parameters in xl sheet entered the UI
    And I query db with results
    Then XL data and DB data must match



