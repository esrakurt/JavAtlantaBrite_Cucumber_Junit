package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KurtDBTestsPage {

    public KurtDBTestsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Sales")
    public WebElement SalesButton;

    @FindBy(xpath = "//tr[@class='o_data_row']")
    public WebElement salesQuotations;
}
