
Feature: Adding game to API

  @tag1
  Scenario: To test Add game in api
    Given I have the base uri
    And I have the query parameter with name "query" and value 
    
     When I make "POST" request to the end point "/graphql"
     Then the response status code should be 200