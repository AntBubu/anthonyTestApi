
@Automated
Feature: Checking the weather for the next few days

  In order to give more personalised message for the weather forecast
  As a member of a development team
  I want to make sure that the API is stable

# Just like my previous tests, by using regex I tried to make them reusable, only the Then statement had to be added.
  # I named my scenarios the same so that they can all appear on the same report

  Scenario: Weather check
    Given the API is up and running
    When Iris calls an API location with a woeid 44418 for London to check the weather
    Then she should see if the forecast for today is Heavy Cloud

  Scenario: Weather check
    Given the API is up and running
    When Iris calls an API location with a woeid 44418 for London to check the weather
    Then she should see if the forecast for tomorrow is Showers

  Scenario: Weather check
    Given the API is up and running
    When Iris calls an API location with a woeid 44418 for London to check the weather
    Then she should see if the forecast for the day after tomorrow is Clear

  Scenario: Weather check
    Given the API is up and running
    When Iris calls an API location with a woeid 44418 for London to check the weather
    Then she should see if the forecast in three days time is Light Cloud
