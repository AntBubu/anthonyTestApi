Feature: Checking the weather for windy days

  In order to fully enjoy my day windsurfing
  As a windsurfer
  I want to check the weather for this week and see if the wind will exceed 30mph

@Manual
  Scenario: Windsurf time this week ?
    Given that I know the woeid of my windsurf spot
    When I check the API location for wind speed for my location
    Then I should be able to know for this week if the wind will exceed 30 mph