package com.specsavers.examples.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GDPRMarkettingPermissionsPage extends PageObject {


    @FindBy(id = "next-btn__2")
    private WebElementFacade nextButton;

    @FindBy(className = "pseudo-check")
    private List<WebElementFacade> questionsMktRadioBtn;

    @FindBy(id = "prev-btn__2")
    private WebElementFacade previousButton;

    public void click_GDPR_Marketting_Permissions_Page_Buttons(int [] questionButton)
    {
        for (int selectCheckBox:questionButton) {
            questionsMktRadioBtn.get(selectCheckBox).click();
        }
    }

    public void click_Next_Button()
    {
        nextButton.click();
    }

}
