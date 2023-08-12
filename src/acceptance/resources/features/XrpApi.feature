Feature: Requesting from the XRPL
  Invoking different XRPL endpoints

  Scenario: Getting the server info of the XRPL
    Given the application is alive
    When the server info is requested
    Then the server info is returned
