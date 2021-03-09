package org.issi.pages;

import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class InstructionsPage extends BasePage{
    private InstructionsPage() {
    }
    private static final By processedToApplyBtn = By.xpath("//input[@value='Proceed to Apply']");
    public static void cickOnProcessedToApply(){
        clickOn(processedToApplyBtn, WaitStrategy.CLICKABLE,"processed to apply");
        waitupto(500);
    }
}
