package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMUserCustomersPage {

    public CRMUserCustomersPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Customers")
    public WebElement customersLink;


    public String getCustomersTitle(){
        String title = Driver.getDriver().findElement(By.xpath("//div[@class='o_control_panel']//ol//li")).getText();

        return title;
    }

}
