package org.issi.pages;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;
import org.issi.enums.ConfigProperties;
import org.issi.enums.WaitStrategy;
import org.issi.utilities.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;



public final class ConfirmationPage extends BasePage {
    private ConfirmationPage() {
    }

    // accept declaration
    private static final By declarationBtn = By.xpath("//input[@id='ckbConfirmation']");
    public static void clickOnDeclaration(){
        waitupto(500);
        scrollByElement(declarationBtn, WaitStrategy.CLICKABLE);
        clickOn(declarationBtn,WaitStrategy.CLICKABLE,"Declaration");
        waitupto(500);
    }

    // get Capacha
    private static final By captcha = By.xpath("//img[@id='ImageCaptcha']");
    public static String getCaptcha() {

        try {
            File src = DriverManager.getDriver().findElement(captcha).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(FrameworkConstants.getCaptchapath()));
            ITesseract instance = new Tesseract();
            instance.setDatapath("tessdata");
            String captchaText = instance.doOCR(new File(FrameworkConstants.getCaptchapath()));
            waitupto(1000);
               log().info("captcha is : "+ captchaText);
            return captchaText;
        } catch (TesseractException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // enter captcha value
    private static final By captchaTextField = By.xpath("//input[@id='clientCaptcha']");
    public static void enterCaptcha(){
        enterText(captchaTextField,getCaptcha(),WaitStrategy.VISIBLE,"Entered Captcha");
        waitupto(500);
    }

    // Enter applicant password
    private static final By appicantPasswrodText = By.xpath("//input[@id='txtPassword']");
    public static void enterApplicantpasswrod(){
        enterText(appicantPasswrodText, PropertyUtils.getValue(ConfigProperties.PASSWORD),WaitStrategy.VISIBLE,"Entered applicant password ");
        waitupto(500);

    }
    // clicking on final submission
    private static final By finalsubBtn = By.xpath("//button[@id='btnSubmit']");
    public static void clickOnFinalSubmit(){
        waitupto(500);
        clickOn(finalsubBtn,WaitStrategy.CLICKABLE,"Final sumbit");

    }

    private static final By confirmMsg = By.xpath("//div[@class='bootstrap-dialog-message']");
    private static final By okBtn = By.xpath("//button[@id='btnOK']");
    public static void applicationConfirmation(String msg){
        String conrmText = DriverManager.getDriver().findElement(confirmMsg).getText();
        if (msg.contains(conrmText)){
            waitupto(500);
            clickOn(okBtn,WaitStrategy.CLICKABLE,"OK");
            waitupto(500);
        }
    }

}
