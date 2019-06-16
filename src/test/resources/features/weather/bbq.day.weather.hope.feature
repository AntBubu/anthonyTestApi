Feature: Checking the weather and hoping for a good day for my bbq party

  In order to fully enjoy my bbq party
  As a hardworking software tester
  I want to check the weather on a specific day

@Manual
  Scenario: BBQ weather or not ?
    Given that I know the date and the woeid location of my bbq party
    When I check the location day weather forecast list for Clear
    Then I should be able to see the forecast result and plan accordingly