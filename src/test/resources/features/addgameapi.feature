
Feature: Adding game to API

  @tag1
  Scenario: To test Add game in api
    Given I have the base uri
    And I have add game query with game name value "Test Game 01" slug value "Test slug 01" and suplier id value 1
     When I make "POST" request to the end point "/graphql"
     Then the response status code should be 200