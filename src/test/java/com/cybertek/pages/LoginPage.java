package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

//    @FindBy(xpath = "//input[@name='csrf_token']")
//    public WebElement hiddenMessage;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;

    //Sign in
    @FindBy(linkText="Sign in")
    public WebElement signIn;

    //Sign in
    @FindBy(linkText="BriteErpDemo")
    public WebElement BriteErpDemo;

    @FindBy(linkText = "CRM")
    public WebElement CRMButton;

    @FindBy(linkText="EventsCRM_Manager")
    public WebElement CRMManagerText;

    @FindBy(linkText="EventsCRM_User")
    public WebElement CRMUserText;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement errorMessage;


    public void clickCRModule() {
        CRMButton.click();
    }


    public void selectBriteErpDemo() {
        BriteErpDemo.click();
    }

    //When you open webpage, click on sign in button
    public void signIn(){ //signIn this line is method name
        signIn.click(); // signIn in this line comes from above WebElement
    }

    public void login(String usr, String pass) {
        email.sendKeys(usr);
        password.sendKeys(pass);
        loginButton.click();
    }

    public void open() {  // This method is not necessary anymore
        // Because drive class provides same function under @Before method
        //it is automatically triggered.
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

}
