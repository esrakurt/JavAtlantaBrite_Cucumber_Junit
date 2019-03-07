package com.cybertek.step_definitions;
import com.cybertek.utilities.DatabaseUtility;
import com.cybertek.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;
public class Hooks {
    @Before
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @Before(value = "@db")
    public void setUpDBConnection(){
        DatabaseUtility.createConnection();

    }
    @After(value = "@db")
    public  void closeDBConnection(){
        DatabaseUtility.closeConnection();
    }
}
