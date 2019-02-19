package com.cybertek.step_definitions;

import com.cybertek.pages.ReportPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CRMManagerReportTestSteps {

    ReportPage reportPage=new ReportPage();

    @Then("user should be able to view Reporting-Pipeline Analysis page")
    public void user_should_be_able_to_view_Reporting_Pipeline_Analysis_page() {
        reportPage.ReportPipeline.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(reportPage.ReportPipeline));
        //BrowserUtils.waitForVisibility(reportPage.ReportPipeline, 20);
        reportPage.ReportPipeline.click();
        wait.until(ExpectedConditions.titleIs("Pipeline Analysis - Odoo"));
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Pipeline Analysis - Odoo"));

    }

    @Then("user should be able to view Reporting-Pipeline Analysis-Total Revenue")
    public void user_should_be_able_to_view_Reporting_Pipeline_Analysis_Total_Revenue() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(reportPage.ReportPipeline));
        //BrowserUtils.waitForVisibility(reportPage.ReportPipeline, 20);
        reportPage.ReportPipeline.click();

        reportPage.RPMeasures.click();
        reportPage.RPMeasuresTotalRevenue.click();
    }


    @Then("user should be able to view Reporting-Pipeline Analysis page following options:")
    public void user_should_be_able_to_view_Reporting_Pipeline_Analysis_page_following_options(List<String> options) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(reportPage.ReportPipeline));
        //BrowserUtils.waitForVisibility(reportPage.ReportPipeline, 20);
        reportPage.ReportPipeline.click();

        reportPage.RPMeasures.click();

        for(int i=0; i<options.size();i++) {
            switch (options.get(i)) {
                case "Count":
                    reportPage.RPMeasuresCount.click();
                    break;

            }
        }

    }

     @Then("user should be able to view Reporting-Pipeline Analysis-{string}")
    public void user_should_be_able_to_view_Reporting_Pipeline_Analysis(String type) {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(reportPage.ReportPipeline));
        //BrowserUtils.waitForVisibility(reportPage.ReportPipeline, 20);
        reportPage.ReportPipeline.click();

        reportPage.RPMeasures.click();

        switch (type){
            case "Delay to Assign":
                reportPage.RPMeasuresDelayToAssign.click();
                break;
            case"Delay to Close":
                reportPage.RPMeasuresDelayToClose.click();
                break;
            case"Overpassed Deadline":
                reportPage.RPMeasuresOverPassedDeadLine.click();
                break;
            case"Number of Activities":
                reportPage.RPMeasuresNumberofActivities.click();
                break;
            case":Probability":
                reportPage.RPMeasuresProbability.click();
                break;

        }


    }

    @Then("user should be able to view Reporting-Activities Analysis page")
    public void user_should_be_able_to_view_Reporting_Activities_Analysis_page() {
        reportPage.ReportActivities.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(reportPage.ReportActivities));
        //BrowserUtils.waitForVisibility(reportPage.ReportPipeline, 20);
        reportPage.ReportActivities.click();
        wait.until(ExpectedConditions.titleIs("Activities Analysis - Odoo"));
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Activities Analysis - Odoo"));
    }

    @Then("user should be able to view Reporting-SalesChannel Analysis page")
    public void user_should_be_able_to_view_Reporting_SalesChannel_Analysis_page() {
        reportPage.ReportSalesChannel.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(reportPage.ReportSalesChannel));
        //BrowserUtils.waitForVisibility(reportPage.ReportPipeline, 20);
        reportPage.ReportSalesChannel.click();

       wait.until(ExpectedConditions.titleIs("Sales Channels - Odoo"));
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Sales Channels - Odoo"));
    }

}

