package org.issi.pages;

import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {
    //constructor
    private LoginPage() {
    }


    //By locators
    private static final By loginUsernameText = By.id("userName");
    private static final By loginPasswordText = By.id("password");
    private static final By loginBtn = By.id("submit");


    //page actions
    public static String getLoginPageTitle(){
        return getPage_Title();
    }

    public static void enterUserName(String usrnm){
        enterText(loginUsernameText,usrnm, WaitStrategy.PRESENCE,"Login username");
        waitupto(500);
    }
    public static void enterPassword(String pwd){
       enterText(loginPasswordText,pwd,WaitStrategy.PRESENCE,"Login Password");
       waitupto(500);
    }
    public static void clickOnLogin(){
        clickOn(loginBtn,WaitStrategy.CLICKABLE,"Login Button");
        waitupto(500);
    }


    public static PersonalInfoPage doLogin(String un, String pwd){
        DriverManager.getDriver().findElement(loginUsernameText).sendKeys(un);
        log().info("Entered username as " + un +" ");
        DriverManager.getDriver().findElement(loginPasswordText).sendKeys(pwd);
        log().info("Entered password as " + pwd +" ");
        DriverManager.getDriver().findElement(loginBtn).click();
        log().info("clicked on login button");
        return new PersonalInfoPage();
    }

}
