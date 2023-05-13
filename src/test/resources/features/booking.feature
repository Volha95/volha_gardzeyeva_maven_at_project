Feature: Booking.com tests

  Scenario: max price per night
    Given I open booking site
    When I input the city
    And Input dates
    And Input adults and rooms
    And Click on button search
    And Sort the hotels
    Then Check the cost of the night
