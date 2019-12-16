package com.specsavers.examples.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class GDPRConfirmationPage extends PageObject {


    @FindBy(id = "consent-submitted-msg")
    private WebElementFacade confirmationMessageText;

    public String get_Confirm_Message_Text() {
        boolean elementDisplayed = false;
        while (elementDisplayed != true) {
            elementDisplayed = confirmationMessageText.isDisplayed();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return confirmationMessageText.getText();

    }
}


