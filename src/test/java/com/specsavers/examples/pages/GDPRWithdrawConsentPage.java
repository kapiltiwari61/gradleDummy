package com.specsavers.examples.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class GDPRWithdrawConsentPage extends PageObject {

    @FindBy(id = "next-btn__3")
    private WebElementFacade nextBtn;


    public void click_Submit_Button()
    {
        nextBtn.click();
    }
}
