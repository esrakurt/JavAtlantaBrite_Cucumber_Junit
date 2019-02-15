@wip
Feature: Report Functinality

  Background:
    Given user on the login page
    When user logs in using "manager"
    Then CRM module should be displayed

  Scenario: CRM Manager should be able view Reporting/Pipeline Analysis page

    Then user should be able to view Reporting-Pipeline Analysis page

  Scenario: CRM Manager should be able view Reporting/Pipeline Analysis/Total Revenue
    And user should be able to view Reporting-Pipeline Analysis-Total Revenue

  Scenario Outline:  CRM Manager should be able view Reporting/Pipeline Analysis Measure Options

    And user should be able to view Reporting-Pipeline Analysis-"<option>"

    Examples:
      | option               |
      | Count                |
      | Delay to Assign      |
      | Delay to Close       |
      | Overpassed Deadline  |
      | Number of Activities |
      | Probability          |


  Scenario: CRM Manager should be able view Reporting/Activities Analysis page
    And user should be able to view Reporting-Activities Analysis page


  Scenario: CRM Manager should be able view Reporting/SalesChannel Analysis page
    And user should be able to view Reporting-SalesChannel Analysis page

