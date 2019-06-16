@Automated

Feature: Checking access to API location using woeid

  In order to test the API more easily
  As a tester
  I want to be able to run queries using woeid location

# I used some basic regex to make the test reusable for other cities and other users (although there was no need for users)
  Scenario: should be able to access API location using woeid
    Given the API is up and running
    When Iris searches for London woeid
    Then she should be able to retrieve it to access another location for London

  Scenario: should be able to access API location using woeid
    Given the API is up and running
    When Iris searches for Paris woeid
    Then she should be able to retrieve it to access another location for Paris