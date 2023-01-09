@regression @smoke @ui
Feature: Validating order creation functionalities

  @RTB-4
  Scenario Outline: Validation order calculation functionality

    Given user navigate to "WebOrders" application
    When user enters username "Tester" and password "test" and clicks on login button
    And user clicks on Order module
    And user selects "<product>" with <quantity>
    Then user validates total is calculated properly for <quantity>


    Examples:
      | product     | quantity |
      | MyMoney     | 10       |
      | FamilyAlbum | 55       |
      | ScreenSaver | 3        |

  @RTB-6
  Scenario Outline: Validating create order functionality
    Given user navigate to "WebOrders" application
    When user enters username "Tester" and password "test" and clicks on login button
    And user clicks on Order module
    And user creates order with data

      | product     | <product>     |
      | quantity    | <quantity>    |
      | name        | <name>        |
      | street      | <street>      |
      | city        | <city>        |
      | state       | <state>       |
      | zip         | <zip>         |
      | cc          | <cc>          |
      | expire date | <expire date> |

    Then user validates success message "New order has been successfully added."

    Examples:
      | product     | quantity | name        | street      | city    | state | zip   | cc                | expire date |
      | MyMoney     | 10       | Patel Harsh | 123 My Road | Chicago | IL    | 12345 | 1234123412341234  | 07/25       |
      | FamilyAlbum | 5        | John Doe    | 321 My Road | Chicago | IL    | 43212 | 1234567887654321  | 03/23       |
      | ScreenSaver | 50       | Bred Pitt   | 231 My Road | Chicago | IL    | 12345 | 98769876987698761 | 05/27       |