package com.cybertek.step_definitions;

import com.cybertek.pages.ManagerPipelinePage;
import com.cybertek.utilities.ApplicationConstants;
import com.cybertek.utilities.BrowserUtils;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ManagerPipelineTestSteps {

    private ManagerPipelinePage pipelinePage = new ManagerPipelinePage();

    @Then("Manager should be able to see Kanban view")
    public void manager_should_be_able_to_see_Kanban_view() {
        pipelinePage.xButtonInSearchBox.click();
        Assert.assertEquals(pipelinePage.getPipelineTitle(), ApplicationConstants.PIPELINE_TITLE);
    }

    @Then("Manager should be able to see List view")
    public void manager_should_be_able_to_see_List_view() {
        pipelinePage.listView.click();
        pipelinePage.firstTableRowInListView.click();
    }

    @Then("Manager should be able to see Pivot view")
    public void manager_should_be_able_to_see_Pivot_view() {
        BrowserUtils.waitForClickablility(pipelinePage.pivotView,10);
        pipelinePage.pivotView.click();
    }

    @Then("Manager should be able to see Calender")
    public void manager_should_be_able_to_see_Calender() {
        pipelinePage.calender.click();
    }

    @Then("Manager should be able to see Graph view")
    public void manager_should_be_able_to_see_Graph_view() {
        pipelinePage.graphView.click();
    }



    @Then("Manager should be display Days to Assign")
    public void manager_should_be_display_Days_to_Assign() {
//        pipelinePage.graphView.click();
//        pipelinePage.measuresButton.click();
        pipelinePage.gotoGraphAndClickMeasures();
        pipelinePage.daysToAssign.click();
        String actualDaysToAssignGraphTitle = pipelinePage.daysToAssignHeader.getText();
        String expectedDaysToAssignGraphTitle = "Days to Assign";
        Assert.assertEquals(actualDaysToAssignGraphTitle,expectedDaysToAssignGraphTitle);
    }

    @Then("Manager should be display Days to Close")
    public void manager_should_be_display_Days_to_Close() {
        pipelinePage.gotoGraphAndClickMeasures();
        pipelinePage.daysToCloseButton.click();
        String actualDaysToCloseGraphTitle = pipelinePage.daysToCloseHeader.getText();
        String expectedDaysToCloseTitle = "Days to Close";
        Assert.assertEquals(actualDaysToCloseGraphTitle,expectedDaysToCloseTitle);
    }

    @Then("Manager should be display Bounce")
    public void manager_should_be_display_Bounce() {
        pipelinePage.gotoGraphAndClickMeasures();
    }

    @Then("Manager should be display Probability")
    public void manager_should_be_display_Probability() {
        pipelinePage.gotoGraphAndClickMeasures();
    }

    @Then("Manager should be display Expected Revenue")
    public void manager_should_be_display_Expected_Revenue() {
        pipelinePage.gotoGraphAndClickMeasures();
    }





}
