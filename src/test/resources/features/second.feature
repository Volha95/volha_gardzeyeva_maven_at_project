Feature: My second demo feature

  Scenario Outline: My demo scenario
    Given I open demoG7 site
    When I fill "<word>" in the form
    Then I need to see something
    Examples:
      | word |
      | buga |
      | vuga |