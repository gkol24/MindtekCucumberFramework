@regression  @UI
  Feature: Pizza application place order functionality
    @RTB-5
    Scenario Outline: Validating successful place order
      Given user navigate to "PizzaApp" application
      When user creates pizza order with data
        | Pizza    | <Pizza>    |
        | Topping1 | <Topping1> |
        | Topping2 | <Topping2> |
        | Quantity | <Quantity> |
        | Name     | <Name>     |
        | Email    | <Email>    |
        | Phone    | <Phone>    |
        | Payment  | <Payment>  |
      Then user validates that order is created with massage "Thank you for your order! TOTAL: " "<Pizza>"


      Examples:
        | Pizza                         | Topping1    | Topping2     | Quantity | Name        | Email           | Phone      | Payment        |
        | Small 6 Slices - no toppings  | Mushrooms   | Extra cheese | 1        | Patel Harsh | patel@gmail.com | 123456789  | Cash on Pickup |
        | Medium 8 Slices - 2 toppings  | Olives      | Salami       | 2        | Brad Pitt   | pitt@gmail.com  | 3219876541 | Credit Card    |
        | Large 10 Slices - no toppings | Italian Ham | Extra cheese | 1        | Kim Yun     | yun@gmail.com   | 987654321  | Cash on Pickup |