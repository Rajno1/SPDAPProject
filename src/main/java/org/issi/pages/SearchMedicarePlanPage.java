package org.issi.pages;

import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class SearchMedicarePlanPage extends BasePage{
    private SearchMedicarePlanPage() {
    }
    // enter organization name and plan name
    private static final By orgnameText = By.xpath("//input[@id='SearchLookupTypecode']");
    public static void enterOrganizatinName(String orgName){
        enterText(orgnameText,orgName,WaitStrategy.PRESENCE,"Organization name");
        waitupto(500);
    }

    private static final By planNameText = By.xpath("//input[@id='SearchLookupTypeName']");
    public static void enterPlanName(String planName){
        enterText(planNameText,planName,WaitStrategy.PRESENCE,"");
    }

}
