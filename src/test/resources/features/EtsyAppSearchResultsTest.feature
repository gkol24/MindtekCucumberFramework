@regression @ui @RTB-1
Feature: Validate Etsy application search and filter functionality


  #Before
  Background:Repeated first steps in each scenario
    Given  user navigate to "Etsy" application


  @RTB-1
  Scenario: Validating search results
    When user searches for "sofa"
    Then user validates search result items name contains keyword "sofa"
  #After



  @RTB-2
  Scenario Outline: Validating price range filter functionality for searched item
    When user searches for "<item>"
    And user applies price filter "<price>" dollars
    Then user validates that item prices are "<price>" dollars
    And user validates search result items name contains keyword "<item>"

    Examples:
      | item       | price       |
      | sofa       | over 1500   |
      | couch      | under 250   |
      | side table | 250 to 750  |
      | chair      | 500 to 1000 |


  @RTB-3
  Scenario Outline: Validating price range and size filters functionality for search item
    When user searches for "<item>"
    And user applies size filter "<size>"
    And user applies price filter "<price>" dollars
    Then user validates item size "<size>" and  that item prices are {string} dollars


    Examples:
      | item      | size  | price     |
      | matteress | Queen | under 500 |
      | sheets    | Queen | over 25   |
      | duvet     | Queen | 50-100    |




