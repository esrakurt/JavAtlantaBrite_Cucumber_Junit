#@wip
Feature: Report Functinality

  Background:
    Given user on the login page
    When user logs in using "manager"
    Then CRM module should be displayed

  Scenario: Reporting/Pipeline Analysis page

    Then user should be able to view Reporting-Pipeline Analysis page

  Scenario: Reporting/Pipeline Analysis/Total Revenue
    And user should be able to view Reporting-Pipeline Analysis-Total Revenue


  Scenario Outline: :Reporting/Pipeline Analysis Measure Options List Method
    And user should be able to view Reporting-Pipeline Analysis page following options:
      | <options> |

    Examples:
      | options         |
      | Count           |
      | Delay to Assign |


  Scenario Outline:  Reporting/Pipeline Analysis Measure <option>

    And user should be able to view Reporting-Pipeline Analysis-"<option>"

    Examples:
      | option               |
      | Delay to Close       |
      | Overpassed Deadline  |
      | Number of Activities |
      | Probability          |


  Scenario: Reporting/Activities Analysis page
    And user should be able to view Reporting-Activities Analysis page


  Scenario: Reporting/SalesChannel Analysis page
    And user should be able to view Reporting-SalesChannel Analysis page


  Scenario Outline: Reporting pages measures options
    When user on the "<page>"
    Then measures options should match with Measure Excel File
    Examples:
      | page       |
      | pipeline   |
      | activities |




