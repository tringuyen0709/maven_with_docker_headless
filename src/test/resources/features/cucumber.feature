Feature: Login functionality

  Scenario: Login
    Given user is on login page with user = "tri" and pass = "123"
    When user enters username and password
    Then user is redirected to homepage