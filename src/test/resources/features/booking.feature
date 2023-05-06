Feature: Booking.com tests

#  Background: I am on the main page of the site
#    Given Open the site

  Scenario: max price per night
    Given I open booking site
    When I input the city
    And Input dates
    And Input adults and rooms
    And Click on button search
    And Sort the hotels
    Then Check the cost of the night
