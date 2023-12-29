Feature: I can find a city inside a state.

@Test1
  Scenario Outline: As a Test Engineer, I want to validate that a text is present in the List.
    Given I navigate to the list page
    When I search <state> in the list
    Then I can find <city> in the list

    Examples:
      | state      | city       |
      | Washington | Washington |
      | New York   | New York   |
      | Hawaii     | Hawaii     |