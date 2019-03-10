Feature: Customers page

  Background:
    Given User on the login page
    Then User logs in using "eventsCRM_User@info.com" and "opJu56KKL39"
    Then User clicks on CRM module

  Scenario: View Customer Page
    Given User on the CRM module
    When User clicks on the Customers page
    Then User should be able to see Customers page.


  Scenario Outline: Create new customer profile
    Given User on the Customers page
    When User clicks on create button
    Then User should be able to enter a '<name>' and save new profile.

    Examples:
      | name  |
      | user1 |

  Scenario: Enter company name
    Given User on the Customers page
    When User clicks on create button
    Then User should select Company option
    Then User should be able to enter company name.
    Then User should be able to click on save to create new customer profile.

  Scenario: Create internal notes
    Given User on the Customers page
    When User clicks on create button
    Then User should be able to select Internal Notes option
    Then User should be able to enter notes in the textbox
    Then User should be able to click on save to create new customer profile.


  Scenario: Enter Sales/Purchase Data
    Given User on the Customers page
    When User clicks on create button
    Then User should be able to select Sales/Purchases option
    Then User should be able to select option Vendor or Customer.
    Then User should be able to click on save to create new customer profile.


  Scenario: Edit Customer Profile
    Given User on the Customers page
    When user selects a profile from the list
    Then User should be able to click on edit
    Then User should be able to make changes
    Then User should be able to click on save to save changes.


  Scenario: Discard changes on Customer Profile
    Given User on the Customers page
    When user selects a profile from the list
    Then User should be able to click on edit
    Then User should be able to make changes
    Then User should be able to click on discard
    Then User should receive a message "The record has been modified, your changes will be discarded. Do you want to proceed?"
    Then User should be able to click on OK button to discard changes.

  Scenario: Search for Customer Profile
    Given User on the Customers page
    When User clicks on the searchbox
    Then User should be able to enter a customer name "Sales" in the search box
    Then User should be able to click enter to filter
    Then User should be able to view the profiles searched for

  Scenario: Clear search box
    Given User on the Customers page
    When User clicks on the x button on the searchbox
    Then User should be able to clear the searchbox

  Scenario: Change the view option for customers list
    Given User on the Customers page
    When User clicks on the listview option
    Then User should be able to view the list of customers in a list format
  @wip
  Scenario: Verify that listview shows name, phone, and email information
    Given User on the Customers page
    When User clicks on the listview option
    Then User should be able to see name, phone, and email information on the listview