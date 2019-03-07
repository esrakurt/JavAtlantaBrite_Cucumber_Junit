package com.cybertek.step_definitions;

import com.cybertek.utilities.DatabaseUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManagerDBTestSteps {

    @Given("there is a list of events in event_types table")
    public void there_is_a_list_of_events_in_event_types_table() {
        String query = "select * from event_type;";
        List<Object> list = DatabaseUtility.getColumnData(query, "name");
        System.out.println(list);
    }

    @Given("event types must be unique")
    public void event_types_must_be_unique() {
        String query = "select * from event_type;";
        List<Object> list = DatabaseUtility.getColumnData(query, "name");
        Set<Object> set = new HashSet<>();
        for (int i = 0 ; i < list.size(); i++) {
            if (!set.contains(list.get(i))) {
                set.add(list.get(i));
            } else {
                System.out.println("duplicated event type is " + list.get(i));
            }
        }

    }


    @Given("the country table in database")
    public void the_country_table_in_database() {
        String query = "select * from countries;";
        List<Object> countryList = DatabaseUtility.getColumnData(query, "country_name");
        System.out.println(countryList);
    }

    @Given("verify that table contains country Turkey")
    public void verify_that_table_contains_country_Turkey() {
        String query = "select * from countries;";
        List<Object> countryList = DatabaseUtility.getColumnData(query, "country_name");
        Assert.assertFalse(countryList.toString().contains("Turkey"));

    }



}
