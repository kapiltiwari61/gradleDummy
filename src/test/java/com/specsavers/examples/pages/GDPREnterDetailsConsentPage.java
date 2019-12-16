package com.specsavers.examples.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GDPREnterDetailsConsentPage extends PageObject {

    @FindBy(id = "select_salutation")
    private WebElementFacade salutationDropDown;

    @FindBy(id = "first_name")
    private WebElementFacade firstNameFreeFormat;

    @FindBy(id="last_name")
    private WebElementFacade lastNameFreeFormat;

    @FindBy(id="select_role")
    private WebElementFacade roleDropDown;

    @FindBy(id="date-of-consent")
    private WebElementFacade dateField;

    @FindBy(id="submit-responsible-adult")
    private WebElementFacade submitButton;

    @FindBy(id="prev-consent-notifier")
    private WebElementFacade consentDateText;

    @FindBy(css = "div.alert.alert-danger")
    private List<WebElementFacade> errorMessage;

    @FindBy(css="label.show-required")
    private WebElementFacade TitleHeader;

    public void create_Consent(String firstName, String surName)
    {
        try{
            salutationDropDown.selectByIndex(1);}
        catch (Exception e){}

        firstNameFreeFormat.sendKeys(firstName);
        lastNameFreeFormat.sendKeys(surName);
        roleDropDown.selectByIndex(1);

    }


    public String return_Date()
    {
        return dateField.getText();
    }

    public void click_Submit()
    {
        submitButton.click();
    }

    public String return_Consent_Provided()
    {
        while(!consentDateText.isDisplayed())
        {}
        return consentDateText.getText();
    }
 }
