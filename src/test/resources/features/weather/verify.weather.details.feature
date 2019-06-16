@Manual
Feature: Verifying other details related to the weather API

  In order to satisfy my natural non-trusting nature
  As a software tester
  I want to check other details on the API

  Scenario: Verify that the London returned is the right one
    Given that there are several places called London in the world
    When I check the weather using a woeid for London
    Then I should see that the parent location is England


    Scenario: BBC is BEST !
      Given that I am a BBC employee and only trust the BBC weather
      When I check the weather using a woeid for London
      Then I should see that the BBC is one of the sources listed