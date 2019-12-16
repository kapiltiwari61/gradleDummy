package com.specsavers.examples.steplibrary;

import com.specsavers.examples.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class UIStepLib extends ScenarioSteps {

    private GDPRLandingPage GDPRlandingPage;
    private com.specsavers.examples.pages.GDPRMarkettingCommsPage GDPRMarkettingCommsPage;
    private com.specsavers.examples.pages.GDPRMarkettingPermissionsPage GDPRMarkettingPermissionsPage;
    private GDPRWithdrawConsentPage GDPRWithdrawConsentPage;
    private com.specsavers.examples.pages.GDPRConfirmationPage GDPRConfirmationPage;
    private com.specsavers.examples.pages.GDPREnterDetailsConsentPage GDPREnterDetailsConsentPage;

    private String consentGivenMessage = "Last updated";
    private Random rand = new Random();
    private int return_Random_Number() {
        return rand.nextInt(999999) + 1;
    }

    public static int GDPRcustomerID;
    public static int GDPRstoreID;
    public static int[] responseArray;

    private int store_generation() throws FileNotFoundException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(filePath+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+ "com/specsavers/Resources/store_numbers"));

        //populate string from file
        String[] formattedStoreList;
        String storeList = new String();
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            storeList = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        formattedStoreList = storeList.split(",");
        int x = rand.nextInt(formattedStoreList.length);
        return Integer.parseInt(formattedStoreList[x]);
    }

    private String dobGeneration(int age)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -age);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(cal.getTime());
    }


    public void GDPR_Navigation(String region, int age, String base) throws FileNotFoundException {
        GDPRcustomerID = return_Random_Number();
        GDPRstoreID = store_generation();
        GDPRlandingPage.open_Browser_And_Enter_GDPR_Url(GDPRcustomerID,GDPRstoreID, region, dobGeneration(age), base);
    }

    public void assert_Next_Button_Not_Clickable()
    {
        assert(GDPRlandingPage.return_Next_Button_Not_Clickable());
    }


    @Step("Navigate to Acting on Behalf page")
    public void click_Acting_On_Behalf_Danger()
    {
        GDPRlandingPage.click_Acting_On_Behalf_DangerFlag();
    }

    @Step("Update all answers on Questionnaire")
    public void update_Application_With_Responses(String responses)
    {
        int[] questionArray = new int[4];
        if (responses.equals("TRUE")) {questionArray[0]=0;questionArray[1]=2;questionArray[2]=4;questionArray[3]=6;}
        if (responses.equals("FALSE")){questionArray[0]=1;questionArray[1]=3;questionArray[2]=5;questionArray[3]=7;}
        if (responses.equals("RANDOM"))
            {questionArray[0]=0+random_Question_Number();
            questionArray[1]=2+random_Question_Number();
            questionArray[2]=4+random_Question_Number();
            questionArray[3]=6+random_Question_Number();}

        responseArray = questionArray;
        GDPRlandingPage.click_Data_Processing_Consent_TRUE_Button();
        GDPRlandingPage.click_Next_Button();
        GDPRMarkettingCommsPage.click_GDPR_Marketting_Comms_Page_Buttons(questionArray);
        GDPRMarkettingCommsPage.click_Next_Button();
        GDPRMarkettingPermissionsPage.click_GDPR_Marketting_Permissions_Page_Buttons(questionArray);
        GDPRMarkettingPermissionsPage.click_Next_Button();
    }

    private int random_Question_Number()
    {
        return rand.nextInt(2);
    }

    public void update_Right_to_Withdraw_Screen()
    {
        click_Submit_Button();
    }

    private void click_Submit_Button()
    {

        GDPRWithdrawConsentPage.click_Submit_Button();
    }

    public void navigate_to_Consent_Page(String region, int age, String link)
    {
        GDPRlandingPage.open_Browser_And_Enter_GDPR_Url(GDPRcustomerID,GDPRstoreID, region, dobGeneration(age), link);

        if (age<16) {GDPRlandingPage.click_Acting_On_Behalf_DangerFlag();}
        if (age>=16) {GDPRlandingPage.click_Acting_On_Behalf();}
    }

    public void assert_Confirmation_Screen()
    {
        assert(GDPRConfirmationPage.get_Confirm_Message_Text()).contains("Request has been successfully submitted");
    }

    public void create_Consent(String firstName, String surName) {
        GDPREnterDetailsConsentPage.create_Consent(firstName, surName);
    }

    public void click_Consent_Submit()
    {
        GDPREnterDetailsConsentPage.click_Submit();
    }

    public void assert_Consent_Stored()
    {
        String consentGivenMessageFormatted = consentGivenMessage;
        assert(GDPREnterDetailsConsentPage.return_Consent_Provided()).contains(consentGivenMessageFormatted);
    }

    public void assert_Date()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        assert(GDPREnterDetailsConsentPage.return_Date()).contains(dtf.format(now));
    }
}

