package com.cybertek.step_definitions;

import com.cybertek.pages.EventPage;
import com.cybertek.pages.ReportPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.DatabaseUtility;
import com.cybertek.utilities.DateUtility;
import com.cybertek.utilities.ExcelUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventTestSteps {

    List<Map<String, String>> excelmaplist;


    @Then("Event module should be displayed")
    public void event_module_should_be_displayed() {
        EventPage eventPage = new EventPage();

        eventPage.EventButton.click();
    }


    @When("Event Categories page open")
    public void event_Categories_page_open() {
        EventPage eventPage = new EventPage();
        eventPage.EventCategories.click();

    }


    @Then("UI data match with Db values")
    public void ui_data_match_with_Db_values() {
        EventPage eventPage = new EventPage();


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



    @When("user create events")
    public void user_create_events() {
        EventPage eventPage=new EventPage();

        eventPage.Create.click();
    }

    @Then("user should use Event_Type Excel file")
    public void user_should_use_Event_Type_Excel_file() {

        EventPage eventPage=new EventPage();


        List<String> elist=new ArrayList<>();

        String path = ".\\src\\test\\resources\\testData/Event_TypeDATA .xlsx";
        String sheetname = "data";

        ExcelUtil excelUtil = new ExcelUtil(path, sheetname);

        excelmaplist = excelUtil.getDataList();

        for (Map<String, String> map : excelmaplist) {

            elist.add(map.get("event_name"));

        }

        for (int i = 0; i <excelmaplist.size() ; i++) {


        eventPage.EventName.sendKeys(excelmaplist.get(i).get("event_name"));
        eventPage.Organizer.click();
        eventPage.Organizer.clear();
        eventPage.Organizer.sendKeys(excelmaplist.get(i).get("organizer"));
        eventPage.EventName.click();
        eventPage.PopUpCreateButton.click();
        eventPage.Location.click();
        eventPage.Location.clear();
        eventPage.Location.sendKeys(excelmaplist.get(i).get("location"));
        eventPage.EventName.click();
        eventPage.PopUpCreateButton.click();
        eventPage.StartDate.click();
        eventPage.StartDate.sendKeys(excelmaplist.get(i).get("start_date"));
        eventPage.EventName.click();
        eventPage.EndDate.click();
        eventPage.EndDate.sendKeys(excelmaplist.get(i).get("end_date"));
        eventPage.Category.click();
        eventPage.Category.sendKeys(excelmaplist.get(i).get("category"));
        eventPage.EventName.click();
        eventPage.Save.click();
        eventPage.PopUpCreateButton.click();
            eventPage.SecondCreate.click();
        }
    }

    @Then("DB vslues should match with Excel File")
    public void db_vslues_should_match_with_Excel_File() {



        String sql = "select * from event_event\n" +
                "where date_begin between '2019-03-14' and '2019-03-16'\n" +
                "and user_id=101;";

        List<Object> listObject = DatabaseUtility.getColumnData(sql, "name");
        boolean exist=false;
        for (int i = 0; i < excelmaplist.size() ; i++) {

          Assert.assertTrue(listObject.toString().contains(excelmaplist.get(1).get("event_name")));

        }



    }



}
