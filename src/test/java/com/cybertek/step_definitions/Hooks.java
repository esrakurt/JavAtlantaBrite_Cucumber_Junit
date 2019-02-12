package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before(order = 2)
    public void setUp(){
        System.out.println("I am setting up the test from the Hooks class!!!");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // you can also add maximize screen here
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("I am reporting the results");
        // I want to take screenshot when current scenario fails.
        // scenario.isFailed()  --> tells if the scenario failed or not
        if (scenario.isFailed()) {
            // this line is for taking screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // this line is adding the screenshot to the report
            scenario.embed(screenshot, "image/png");
        }

        System.out.println("Closing driver");
        Driver.closeDriver();
    }
}
