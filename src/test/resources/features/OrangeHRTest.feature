Feature: Validate OrangeHR adding and deleting functionality

  @OHR-1
  Scenario: Validate login and creating new user functionality
    Given user navigate to "OrangeHR" application
    When user enters username1 "Admin" and password1 "admin123" and clicks on login button1
    And user click on Admin selection
    And user click on Add button