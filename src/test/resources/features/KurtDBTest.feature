Feature: Kurt DB Tests

  Background:
    Given user on the pipeline page after login using valid credentials

  Scenario: Verify the Sales-Quotation Numbers
    When user is on Sales page
    Then gets the list of quotation numbers from UI
    Then gets the list of quotation numbers form DB
    And verify that the quotation numbers are matching