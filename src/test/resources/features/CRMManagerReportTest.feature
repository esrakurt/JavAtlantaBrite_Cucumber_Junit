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



  Scenario:CRM Manager should be able view Reporting/Pipeline Analysis Measure Options List Method
    And user should be able to view Reporting-Pipeline Analysis page following options:
      | Count |

  @wip
  Scenario Outline:  CRM Manager should be able view Reporting/Pipeline Analysis Measure <option>

    And user should be able to view Reporting-Pipeline Analysis-"<option>"

    Examples:
      | option               |
      | Delay to Assign      |
      | Delay to Close       |
      | Overpassed Deadline  |
      | Number of Activities |
      | Probability          |


  Scenario: CRM Manager should be able view Reporting/Activities Analysis page
    And user should be able to view Reporting-Activities Analysis page


  Scenario: CRM Manager should be able view Reporting/SalesChannel Analysis page
    And user should be able to view Reporting-SalesChannel Analysis page





