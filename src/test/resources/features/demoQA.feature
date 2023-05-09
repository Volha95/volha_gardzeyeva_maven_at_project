Feature: DemoQA tests

  Scenario: select any values from the dropdown lists
    Given I open demoQA-select page
    When I select value
    And I select one
    And I select old style select
    And I select multiselect drop down
    Then I select standard multi select
