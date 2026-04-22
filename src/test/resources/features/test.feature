Feature: Test

@C001
  Scenario: Simple test
    Given I create a new user
    When I change user's name
    Then Name is changed