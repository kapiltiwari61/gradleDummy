Feature: UITests
  In order to express my consent,
  as a user,
  I want to submit a GDPR Questionnaire

  @GDPR_UI @RegressionTest @SmokeTest @Positive @WriteData @TCG-104
  Scenario Outline: Consent is given and persisted
    Given user has accessed UAT_5 Version GDPR Landing Page <Region>, <Age>
    And user has accessed GDPR Landing Page for Under 16
    When Consent on Behalf is Given
    And user navigates through GDPR Application with <Responses> Responses
    And user submits application
    Then user will get confirmation screen
    And consent has been persisted <Region>, <Age>, UAT_5

    Examples:
      |Responses|Region|Age|
      |TRUE     |GB    |15|