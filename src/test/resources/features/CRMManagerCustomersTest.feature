@wip
@BRIT-4200
Feature: User should be able to see current customer cards, and create new customer cards


  Background:
    Given navigate to URL and select BriteErpDemo database
    And login with valid credentials
    When navigate CRM module
    Then go to Customers page


  @BRIT-3186
  Scenario: Displaying current customer cards
    When Customers header is displayed
    Then customer cards exist on the page

  @BRIT-3181
  Scenario: Missing entry
    When go to Create screen
    Then leave the name field empty
    And click on save button
    Then error message should be displayed

  @BRIT-3157
  Scenario: Auto-navigating to Customers page
    When go to Create screen
    And fill the required fields
    And click on save button
    Then it should navigate to the new customers account page

  @BRIT-3161
  Scenario: Discard button cancels the process
    When go to Create screen
    And fill the required fields
    Then click on Discard button
    And warning message should exist
    Then click on Ok button
    Then it should navigate back to the Customers page

  @BRIT-3183
  Scenario: List button switches the page to list view
    Given Kanban view is selected as default
    When click on List button
    Then the page switches to list view

  @BRIT-3167
  Scenario: Individual and Company radio buttons
    When go to Create screen
    Given Individual radio button is selected as default
    And Company radio button is not selected
    When click on Company button
    Then Individual button will be un-selected
    And Company button will be selected

  @BRIT-3170
  Scenario: Total customer cards
    When total number of customer cards should be 80

  @BRIT-3174
  Scenario: Right arrow button
    When click on right arrow button
    Then verify that number interval "81-160" displayed
    When total number of customer cards should be 80

  @BRIT-3178
  Scenario: Left arrow button
    Then save all customer names on existing cards
    When click on right arrow button
    And click on left arrow button
    Then save all customer names on existing cards again
    And verify that two name lists match

  @BRIT-3151
  Scenario: List view and Kanban view same lists
    Then save all customer names on existing cards
    When click on List button
    Then save all customer names on existing cards in List view
    And verify that two name lists are matching





