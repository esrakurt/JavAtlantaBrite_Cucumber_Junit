package com.cybertek.step_definitions;

import com.cybertek.pages.EmployeesPage;
import com.cybertek.utilities.DatabaseUtility;
import com.cybertek.utilities.ExcelUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesTestSteps {


    EmployeesPage ep = new EmployeesPage();

    String query = "SELECT * FROM hr_employee ORDER BY name ASC;";

    Connection connection;
    Statement statement;
    ResultSet resultSet;


    String url = "jdbc:postgresql://54.148.96.210:5432/BriteErpDemo";
    String user = "podoo";
    String password ="podoo";




    @When("Employees page open")
    public void employees_page_open() throws InterruptedException {
        Thread.sleep(2000);
        ep.employeesLink.click();
    }


    @Then("Employee names in UI match with Db records")
    public void employee_names_in_UI_match_with_Db_records() throws SQLException {
        List<String> namesInUI = new ArrayList<>();
        for(WebElement nameElement : ep.employeeNameElements){
            namesInUI.add(nameElement.getText());
        }

        //List<Object> namesInDB = DatabaseUtility.getColumnData(query, "name");
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(query);

        List<String> namesInDB = new ArrayList<>();
        while(resultSet.next()){
            namesInDB.add(resultSet.getObject("name").toString());
        }

        Assert.assertEquals(namesInUI, namesInDB);
        connection.close();
    }



    @Then("Employee IDs in DB records match with excel sheet")
    public void employee_IDs_in_DB_records_match_with_excel_sheet() throws SQLException {
        ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/testData/Employees.xlsx", "Sayfa1");
        List<String> stringsInExcel = excelUtil.getColumnData(0);

        List<Integer> intExcel = new ArrayList<>();
        for(String cell : stringsInExcel) {
            intExcel.add(Integer.parseInt(cell.substring(0, cell.length()-2)));
        }

        List<String> namesInExcel = new ArrayList<>();
        for(Integer a : intExcel){
            namesInExcel.add(a.toString());
        }

        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(query);

        List<String> namesInDB = new ArrayList<>();
        while(resultSet.next()){
            namesInDB.add(resultSet.getObject("id").toString());
        }

        Assert.assertEquals(namesInExcel, namesInDB);
        connection.close();
    }


}
