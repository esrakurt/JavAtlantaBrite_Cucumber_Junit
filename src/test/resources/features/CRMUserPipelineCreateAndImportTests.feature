Feature: CRM User Pipeline Page Create and Import Functionalities and Qualified Page
  As a CRM user,
  I should be able to click pipeline under main title pipeline and use create and import functionalities and
  I should be able to click on any title under Qualified title to see the details and mark as won or lost.

  Background:
    Given user on the pipeline page after login using valid credentials

#  @wip
  Scenario Outline: Create an Opportunity as User Test
    When Click on create button
    Then Enter name of new opportunity as "<opportunity>"
    Then Enter expected revenue
    Then Click on one of the priority stars
    And Click on create
#    Then Close driver
    Examples:
      | opportunity |
      | Sale 1      |
      | Sale 2      |

  Scenario: Change the opportunity information as user Test
    When Click on recently created opportunity
    Then Click on edit button
    Then Clear the information
    Then Enter new information "New Sale 2"
    And Click on save button

  Scenario:Searching Opportunity Test
    When Clear the search box by clicking the x
    Then Enter the name of recently created opportunity "New Sale 2"
    And Verify the name of the opportunity is matching with the name of opportunity created

  Scenario:Importing a File Test
    When Click on import button
    Then Verify the the title includes Import a File
    And Click on Load File button.

  Scenario:Verifying Create and Import Test
    When Verify the create and import buttons are existing.

  Scenario:Item Under Qualified Category
    When Clear the search box by clicking the x
    Then Click on any opportunity under Qualified
    And Verify the the title includes expected title

  Scenario Outline:Changing Status Tests
    When Clear the search box by clicking the x
    Then Click on <order> opportunity under Qualified
    And Click on Mark Won
    Then Verify that the status has changed to won
    And Click on Mark Lost
    And Enter any reason to change the status
    Then Click on submit
    And Verify that the status has changed to lost
#    Then Close driver
  Examples:
    |order|
    | 1   |
    | 2   |

  Scenario Outline:Module Options Tests
#    When Open URL
#    Then Enter "email"
#    And Enter "password"
#    Then Click on login button
    And Verify the module tabs contains "<moduleName>" module
#    Then Close driver
    Examples:
      | moduleName |
      | CRM        |
      | Discuss    |
      | Calendar   |


