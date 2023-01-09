Feature: WebOrders application login feature

  Scenario: Validating login feature with valid credentials
    #before
    Given user navigate to "WebOrders" application
    When user enters username "Tester" and password "test" and clicks on login button
    Then user validates application is logged in
    #after

  Scenario: Validate login feature with invalid credential
    #before
    Given  user navigate to "WebOrders" application
    When user enters username "Invalid" and password "invalid" and clicks on login button
    Then user validates an error message "Invalid Login or Password."
    #after