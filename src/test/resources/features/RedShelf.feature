@regression @ui @RTB-7
Feature: Validating RedShelf application search and filter functionalities

  Background:Repeated first steps in each scenario
    Given  user navigate to "RedShelf" application


  @RTB-7
  Scenario: Validating "Purple Cow" book in a cart
    When user searches "Purple Cow" book
    And user choose first book in search result
    And user clicks on Add To Cart button
    Then user clicks on view cart button and validates book is in cart

  @RTB-8
  Scenario: Validating search functionality
    When user searches "Java data structure" book
    Then user validates first result page having no more than 25 books.

  @RTB-9
  Scenario:Validating "Your Cart is Empty" message
    When user searches "Purple Cow" book
    And user choose first book in search result
    And user click on Add To Cart button
    And user clicks on empty cart button
    Then user validates “Your Cart is Empty“ message

  @RTB-10
  Scenario:Validating "book" search by ISBN number
    When user clicks on "book" and stores ISBN number
    When user search for a book with stored ISBN number
    Then user validates that search result has book

