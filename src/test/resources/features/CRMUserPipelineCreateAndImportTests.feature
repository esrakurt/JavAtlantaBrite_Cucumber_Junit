Feature: CRM User Pipeline Page Create and Import Functionalities and Qualified Page
  As a CRM user,
  I should be able to click pipeline under main title pipeline and use create and import functionalities and
  I should be able to click on any title under Qualified title to see the details and mark as won or lost.

  Background:
    Given user on the pipeline page after login using valid credentials


  Scenario Outline: Create an Opportunity as User Test
    When Click on create button
    Then Enter name of new opportunity as "<opportunity>"
    Then Enter expected revenue
    Then Click on one of the priority stars
    And Click on create
    Examples:
      | opportunity |
      | Sale 1      |
      | Sale 2      |


  Scenario Outline:Item Under New Category
    When Clear the search box by clicking the x
    Then Click on the "<new created opportunity>" under New
    Then Verify the name of opportunity includes "<new created opportunity>"
    Examples:
      | new created opportunity |
      | Sale 1                  |
      | Sale 2                  |


  Scenario Outline: Change the opportunity information as user Test
    When Click on recently created "<oppt>"
    Then Click on edit button
    Then Clear the information
    Then Enter new information "<title>"
    And Click on save button
    Examples:
      | oppt   | title      |
      | Sale 1 | New Sale 1 |
      | Sale 2 | New Sale 2 |


  Scenario Outline:Searching Opportunity Test
    When Clear the search box by clicking the x
    Then Enter the name of recently created "<new opportunity>"
    And Verify the name of the opportunity is matching with the name of "<new opportunity>"
    Examples:
      | new opportunity |
      | New Sale 1      |
      | New Sale 2      |


  Scenario Outline:Changing Status Tests
    When Clear the search box by clicking the x
    Then Click on "<opportunity>" under New
    And Click on Mark Won
    Then Verify that the status has changed to won
    And Click on Mark Lost
    And Enter "<reason>" to change the status
    Then Click on submit
    And Verify that the status has changed to lost
    Examples:
      | opportunity | reason          |
      | New Sale 1  | expensive       |
      | New Sale 2  | decision change |


  Scenario:Importing a File Test
    When Click on import button
    Then Verify the the title includes Import a File
    And Click on Load File button.


  Scenario:Verifying Create and Import Test
    When Verify the create and import buttons are existing.


//  @wip
  Scenario Outline:Module Options Tests
    And Verify the module tabs contains "<moduleNames>" module
    Examples:
      | moduleNames |
      | module      |



