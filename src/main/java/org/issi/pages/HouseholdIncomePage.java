package org.issi.pages;

import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class HouseholdIncomePage extends BasePage{
    private HouseholdIncomePage() {
    }
    // clicking add new house hold income link
    private static final By addNewHouseHoldIncomeLink = By.xpath("//a[@id='addnewHouseHoldIncome']");
    public static void clickOnHouseHoldIncomeLink(){
        clickOn(addNewHouseHoldIncomeLink, WaitStrategy.CLICKABLE,"Add New House Hold Income");
        waitupto(500);
    }

    // select Income Type
    private static final By incometypeDrpDwn = By.xpath("//select[@id='ddlHouseHoldIncomeType']");
    public static void selectIncomeType(String incmvalue){
        selectFromDrpDwn(incometypeDrpDwn,WaitStrategy.CLICKABLE,incmvalue,"Income Type");
        waitupto(500);
    }

    // Enter applicant income
    private static final By applicantIncomeText = By.xpath("//input[@id='txtApplicantIncome']");
    public static void enterApplicantIncome(String incomeValue){
        enterText(applicantIncomeText,incomeValue,WaitStrategy.VISIBLE,"Applicant Income");
        waitupto(500);
    }

    // Enter spouse income
    private static final By spouseIncomeText = By.xpath("//input[@id='txtSpouseIncome']");
    public static void enterspouseIncome(String incomeValue){
        enterText(spouseIncomeText,incomeValue,WaitStrategy.VISIBLE,"Applicant Income");
        waitupto(500);
    }

    // Enter other member income
    private static final By otherMemIncomeText = By.xpath("//input[@id='txtOthrMembrsIncome']");
    public static void enterOtherMemIncome(String othermemincomeValue){
        waitupto(500);
        enterText(otherMemIncomeText,othermemincomeValue,WaitStrategy.VISIBLE,"Other memeber Income");
        waitupto(500);
    }
    // declaring .getAttribute argument as constant
    private static final String VALUE = "value";
    // adding all incomes
    public static int toalIncomeValue(){
        int applicantincome = Integer.parseInt(DriverManager.getDriver().findElement(applicantIncomeText).getAttribute(VALUE));
        int spouseincome = Integer.parseInt(DriverManager.getDriver().findElement(spouseIncomeText).getAttribute(VALUE));
        int othermemincome = Integer.parseInt(DriverManager.getDriver().findElement(otherMemIncomeText).getAttribute(VALUE));
        return applicantincome+spouseincome+othermemincome;

    }
    // getting the total value of incomes
    private static final By taxtotalText = By.xpath("//input[@id='txtTotal']");
    public static int getTotalTaxValue(){
       String totalTax = DriverManager.getDriver().findElement(taxtotalText).getAttribute(VALUE);
       return Integer.parseInt(totalTax);
    }

    // selcting proof submission option
    private static final By proofSubmissionYesRadBtn = By.xpath("//input[@id='rbtnproffsubmittedYes']");
    private static final By proofSubmissionNoRadBtn = By.xpath("rbtnproffsubmitted");

    public static void selectProofSubmissionValue(String value){
        if (value.equalsIgnoreCase("Yes")){
            clickOn(proofSubmissionYesRadBtn,WaitStrategy.CLICKABLE,"Yes");
            waitupto(500);
        } else if (value.equalsIgnoreCase("No")){
            clickOn(proofSubmissionNoRadBtn,WaitStrategy.CLICKABLE,"No");
            waitupto(500);
        }
    }

    //file upload for proof submission
    private static final By proofuploadBtn = By.xpath("//input[@id='fileuploadIncomeProof']");
    public static void uploadPoof(){
        enterText(proofuploadBtn, FrameworkConstants.getPowerOfAttorneyFormPath(),WaitStrategy.CLICKABLE,"upload proof");
        waitupto(500);
    }

    //Household income submit button
    private static final By householdSubBtn = By.xpath("//button[contains(text(),'Submit')]");
    public static void clickOnHouseHoldIncomeSubmit(){
        clickOn(householdSubBtn,WaitStrategy.CLICKABLE,"House hold Submit button");
        waitupto(500);
    }

    //Household next button
    private static final By householdNext = By.xpath("//button[@id='nextHouseholdBtn']");
    public static void clickOnHouseHoldNextBtn(){
        clickOn(householdNext,WaitStrategy.CLICKABLE,"Next");
        waitupto(500);
    }
}
