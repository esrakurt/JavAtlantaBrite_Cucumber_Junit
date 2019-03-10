
Feature: Excel Testing

#  @wip
  Scenario: Verify if event types are duplicated in event_types table
    Given a list of quotations specifications
    And return all specification on xls sheet
    Then verify that spreadsheet contains "Sales Person"

