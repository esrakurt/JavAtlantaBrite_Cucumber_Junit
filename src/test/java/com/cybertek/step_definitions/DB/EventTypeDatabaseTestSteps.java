package com.cybertek.step_definitions.DB;

import com.cybertek.pages.EventPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.DatabaseUtility;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventTypeDatabaseTestSteps {


    @Then("Event module should be displayed")
    public void event_module_should_be_displayed() {
        EventPage eventPage = new EventPage();

        eventPage.EventButton.click();
    }

    @Then("UI data match with Db values")
    public void ui_data_match_with_Db_values() {
        EventPage eventPage = new EventPage();
        eventPage.EventCategories.click();


        String sql = "select * from event_type";

        List<Object> listObject = DatabaseUtility.getColumnData(sql, "name");

        List<WebElement> eventList= eventPage.EventList;
        List<String> uiEventList= new ArrayList<>();

        for (WebElement s: eventList){
            uiEventList.add(s.getText());
        }
        System.out.println("uiEventList = " + uiEventList);
        System.out.println("listObject = " + listObject.toString());


           Assert.assertEquals(uiEventList,listObject);


    }

    @Then("Below data should match in DB Event Type -{string}")
    public void below_data_should_match_in_DB_Event_Type(String options) {
        EventPage eventPage = new EventPage();

        String sql = "select * from event_type";
        List<Object> listObject = DatabaseUtility.getColumnData(sql, "name");
        boolean exist = false;
        for (Object s : listObject) {


            if (s.toString().contains(options)) {
                exist = true;
            }

        }

        Assert.assertTrue(exist);

    }
}

