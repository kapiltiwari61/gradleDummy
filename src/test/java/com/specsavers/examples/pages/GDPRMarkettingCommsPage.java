package com.specsavers.examples.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class GDPRMarkettingCommsPage extends PageObject {

    @FindBy(id = "next-btn__1")
    private WebElementFacade nextButton;

    @FindBy(className = "pseudo-check")
    private List<WebElementFacade> questionsMktRadioBtn;

    @FindBy(id = "prev-btn__1")
    private WebElementFacade previousButton;

    @FindBy(xpath = "//div[contains(@class, 'question-supplement')]")
    private List<WebElementFacade> serviceCommunicationLink;

    public void click_Next_Button()
    {
        nextButton.click();
    }

    public void click_GDPR_Marketting_Comms_Page_Buttons(int[] questionButton)
    {
        for(int selectCheckBox:questionButton)
        {
            questionsMktRadioBtn.get(selectCheckBox).click();
        }
    }

}