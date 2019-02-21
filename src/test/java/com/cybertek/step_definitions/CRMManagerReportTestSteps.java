package com.cybertek.step_definitions;

import com.cybertek.pages.ReportPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CRMManagerReportTestSteps {

    ReportPage reportPage = new ReportPage();

    @Then("user should be able to view Reporting-Pipeline Analysis page")
    public void user_should_be_able_to_view_Reporting_Pipeline_Analysis_page() {
        reportPage.ReportPipeline.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(reportPage.ReportPipeline));
        //BrowserUtils.waitForVisibility(reportPage.ReportPipeline, 20);
        reportPage.ReportPipeline.click();
        wait.until(ExpectedConditions.titleIs("Pipeline Analysis - Odoo"));
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Pipeline Analysis - Odoo"));

    }

    @Then("user should be able to view Reporting-Pipeline Analysis-Total Revenue")
    public void user_should_be_able_to_view_Reporting_Pipeline_Analysis_Total_Revenue() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
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

        for (int i = 0; i < options.size(); i++) {
            switch (options.get(i)) {
                case "Count":
                    reportPage.RPMeasuresCount.click();
                    break;
                case "Delay to Assign":
                    reportPage.RPMeasuresDelayToAssign.click();
                    break;

            }
        }

    }

    @Then("user should be able to view Reporting-Pipeline Analysis-{string}")
    public void user_should_be_able_to_view_Reporting_Pipeline_Analysis(String type) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(reportPage.ReportPipeline));
        //BrowserUtils.waitForVisibility(reportPage.ReportPipeline, 20);
        reportPage.ReportPipeline.click();

        reportPage.RPMeasures.click();

        switch (type) {

            case "Delay to Close":
                reportPage.RPMeasuresDelayToClose.click();
                break;
            case "Overpassed Deadline":
                reportPage.RPMeasuresOverPassedDeadLine.click();
                break;
            case "Number of Activities":
                reportPage.RPMeasuresNumberofActivities.click();
                break;
            case ":Probability":
                reportPage.RPMeasuresProbability.click();
                break;

        }


    }

    @Then("user should be able to view Reporting-Activities Analysis page")
    public void user_should_be_able_to_view_Reporting_Activities_Analysis_page() {
        reportPage.ReportActivities.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
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
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(reportPage.ReportSalesChannel));
        //BrowserUtils.waitForVisibility(reportPage.ReportPipeline, 20);
        reportPage.ReportSalesChannel.click();

        wait.until(ExpectedConditions.titleIs("Sales Channels - Odoo"));
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Sales Channels - Odoo"));
    }

    public static String currentPage;

    @When("user on the {string}")
    public void user_on_the(String page) {
        ReportPage reportPage = new ReportPage();
        currentPage = page;
        switch (page) {
            case "pipeline":
                reportPage.ReportPipeline.click();
                break;
            case "activities":
                reportPage.ReportActivities.click();
                break;
        }

    }

    @Then("measures options should match with Measure Excel File")
    public void measures_options_should_match_with_Measure_Excel_File() {

        ReportPage reportPage = new ReportPage();
        reportPage.RPMeasures.click();

        List<WebElement> actualList = reportPage.MeasureOptions;
        List<String> alist=new ArrayList<>();
        for (WebElement web : actualList) {
            alist.add(web.getText());

        }
        List<String> elist=new ArrayList<>();

        String path = ".\\src\\test\\resources\\testData\\Measure Options.xlsx";
        String sheetname = currentPage.equalsIgnoreCase("pipeline") ? "Pipeline" : "Activities";

        ExcelUtil excelUtil = new ExcelUtil(path, sheetname);
        List<Map<String, String>> excelmaplist = excelUtil.getDataList();

        for (Map<String, String> map : excelmaplist) {

            elist.add(map.get("Options"));

        }

        System.out.println("alist = " + alist);
        System.out.println("elist = " + elist);
        Assert.assertEquals(alist,elist);

    }

}

