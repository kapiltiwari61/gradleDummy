Feature: APIRequests

  Background:
    Given a clean session

@CXP-729 @Test1
  Scenario Outline: Verify SAS POST returns 200
    When a POST Request is performed <storeID>, <slotId>
    Then the response status code is 200
    And the response message is equal to Booked

    Examples:
      | storeID | slotId|
      | 9001    |41172  |

  @CXP-1453
  Scenario Outline: Verify SAS GET Diary Search returns 502
    When a GET Request is performed for Weekly Diary <storeID>, <mockId>
    Then the response message is equal to Store is currently unavailable
    Then the response status code is 502

    Examples:
      | storeID | mockId|
      | 9001    | 05-02  |