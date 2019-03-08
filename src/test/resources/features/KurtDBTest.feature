Feature: Kurt DB Tests

  Background:
    Given user on the pipeline page after login using valid credentials


  Scenario: Verify the Sales-Quotation Numbers
    When user is on Sales page
    Then gets the list of quotation numbers from UI
    Then gets the list of quotation numbers form DB
    And verify that the quotation numbers are matching


  Scenario: Verify the amount of total sales
    When user is on Sales page
    Then gets the list of sales total from UI
    Then gets the list of sales total form DB
    And verify that the total numbers are matching

  @wip @db
    Scenario: Verify the name and price of Apple In-Ear Headphones
    When user is on Sales page
    Then user navigate to products page
    And gets the product name and price from website
    Then verify the data