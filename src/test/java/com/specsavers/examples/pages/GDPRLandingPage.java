package com.specsavers.examples.pages;

import com.specsavers.core.Properties;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GDPRLandingPage extends PageObject {

    @FindBy(className = "checkmark")
    private List <WebElementFacade> yesRadioBtn;

     @FindBy(xpath = "//label[contains(@for,'question')]")
    private List<WebElementFacade> questionsRadioBtn;

    @FindBy(xpath = "//button[@class='btn-primary btn-danger']")
    private List<WebElementFacade> actingButton;

    @FindBy(css = "button.btn-primary")
    private WebElementFacade actingOnBehalfButton;

    @FindBy(id = "next-btn__0")
    private WebElementFacade nextButton;

    @FindBy(id = "previous-consent")
    private WebElementFacade consentGivenText;

    @FindBy(tagName = "body")
    private WebElementFacade bodyText;

    @FindBy(xpath = "//input[@autocomplete='email']")
    private WebElementFacade emailButton;

    @FindAll({
    @FindBy(xpath = "//*[contains(text(),'Add to the basket')]"),
    @FindBy(xpath = "//*[contains(text(),'a la cesta')]")})
    private WebElementFacade addToBasket;



    private String uat_5baseUrl = Properties.getUAT5BaseURL();

    public void open_Browser_And_Enter_GDPR_Url(int customerNumber, int storeNumber, String region, String DOB, String base) {

             getDriver().get(uat_5baseUrl + "customerNumber=" + customerNumber + "&storeNumber=" + storeNumber + "&user=Sycle&dateOfBirth=" + DOB + "&sourceIndicator=socrates&storeCountryCode=" + region);
        }

      public void click_Data_Processing_Consent_TRUE_Button()
    {
        if(yesRadioBtn.size()>0)
        {
            yesRadioBtn.get(0).click();
        }
        if(questionsRadioBtn.size()>0)
        {
            questionsRadioBtn.get(0).click();
        }
    }

    public void click_Next_Button()
    {
        if (!nextButton.isEnabled())
        {
            click_Data_Processing_Consent_TRUE_Button();
        }
        nextButton.click();
    }

    public void click_Acting_On_Behalf_DangerFlag(){

        while(actingButton.size()==0){}
        actingButton.get(0).click();
    }

    public void click_Acting_On_Behalf()
    {

        actingOnBehalfButton.click();
    }

    public boolean return_Next_Button_Not_Clickable()
    {
        try {
            nextButton.click();
            return false;
        }
        catch (Exception e)
        {
            return true;
        }
    }
}