Feature: W3schools tests

  Scenario: copy and count 'Tutorial' word
    Given I open W3schools site
    When I copy the word
    And Go to Google
    And Paste the word to the Google search
    Then Count number of words