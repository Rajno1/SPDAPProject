package org.issi.pages;

import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class SearchApplicantPage extends BasePage {
    private SearchApplicantPage() {
    }
    // Application number search field
    private static final By appserach = By.xpath("//input[@id='SearchApplication']");

    public static void enterApplicantNumber(Integer appnumber){
        waitupto(500);
        enterText(appserach,String.valueOf(appnumber), WaitStrategy.PRESENCE,"Applicant number");
    }

    // Applicant name search field
    private static final By appname = By.xpath("//input[@id='SearchApplicantName']");
    public static void enterApplicantName(String applicantname){
        waitupto(500);
        enterText(appname,applicantname,WaitStrategy.PRESENCE,"Applicant name as");
    }


     // identifying the table,row and column
    private static final By table  = By.xpath("//table[@id='tblApplications']");
    private static final By tableRow = By.xpath("//table[@id='tblApplications']//tbody/tr");


    public static boolean searchByApplicantNum(Integer appNum){
        boolean staus = false;
        WebElement tablefield =  DriverManager.getDriver().findElement(table);
      int rowSize = DriverManager.getDriver().findElements(tableRow).size();
        for (int i=1;i<=rowSize;i++){
            //Here i am converting applicant number from interger to string
          Integer actAppNum = Integer.parseInt(tablefield.findElement(By.xpath("//table[@id='tblApplications']//tbody/tr["+i+"]/td[2]")).getText());
          if (actAppNum.equals(appNum)){
                staus = true;
          }
        }
        return staus;
    }


    public static boolean searchByApplicantName(String appName){
        boolean staus = false;
        WebElement tablefield =  DriverManager.getDriver().findElement(table);
        int rowSize = DriverManager.getDriver().findElements(tableRow).size();
        for (int i=1;i<=rowSize;i++){
            //Here i am converting applicant number from interger to string
            String actAppName = tablefield.findElement(By.xpath("//table[@id='tblApplications']//tbody/tr["+i+"]/td[3]")).getText();
            if (actAppName.equalsIgnoreCase(appName)){
                staus = true;
            }
        }
        return staus;
    }
}
