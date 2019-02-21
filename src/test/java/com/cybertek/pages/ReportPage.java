package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReportPage {

    public ReportPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-menu='279']")
    public WebElement ReportPipeline ;

    @FindBy(xpath = "//a[@data-menu='278']")
    public WebElement ReportActivities ;

    @FindBy(xpath = "//a[@data-menu='269']")
    public WebElement ReportSalesChannel ;


    //@FindBy(xpath = "(//li[@class=\"active\"])[3]")
    @FindBy(css = ".breadcrumb>li")
    public WebElement ReportPipelinePage;



    @FindBy(xpath = "//div//button[@class='btn btn-primary btn-sm dropdown-toggle']")
    public WebElement RPMeasures ;

    @FindBy(xpath = "(//div[@class='btn-group btn-group-sm open']//li)[9]")
    public WebElement RPMeasuresCount;


    @FindBy(xpath = "(//div[@class='btn-group btn-group-sm open']//li)[7]")
    public WebElement RPMeasuresTotalRevenue;

    @FindBy(xpath = "(//div[@class='btn-group btn-group-sm open']//li)[6]")
    public WebElement RPMeasuresProbability;

    @FindBy(xpath = "(//div[@class='btn-group btn-group-sm open']//li)[5]")
    public WebElement RPMeasuresNumberofActivities;

    @FindBy(xpath = "(//div[@class='btn-group btn-group-sm open']//li)[4]")
    public WebElement RPMeasuresOverPassedDeadLine;

    @FindBy(xpath = "(//div[@class='btn-group btn-group-sm open']//li)[3]")
    public WebElement RPMeasuresDelayToClose;

    @FindBy(xpath = "(//div[@class='btn-group btn-group-sm open']//li)[2]")
    public WebElement RPMeasuresDelayToAssign;

    @FindBy(xpath = "(//div[@class='btn-group btn-group-sm open']//li)[1]")
    public WebElement RPMeasuresProbableTurnover;

    @FindBy(xpath = "//div[@class='btn-group btn-group-sm open']//li")
    public List<WebElement> MeasureOptions;




    public String getreportpipelineTitle(){
        String title = Driver.getDriver().getTitle();
        return title;
    }


    public WebElement getMeasureOptions(String idx){

        String xpath = "(//div[@class='btn-group btn-group-sm open']//li)["+idx+"]";
        return Driver.getDriver().findElement(By.xpath(xpath));

    }




}
