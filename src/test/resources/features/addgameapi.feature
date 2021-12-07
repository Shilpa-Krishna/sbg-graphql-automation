
Feature: Adding game to API

  
  Scenario: To test Add game in api
    Given I have the base uri
    And I have add game query with game name value "Test Game 01" slug value "Test slug 10" and suplier id value 1
    When I make "POST" request to the end point "/graphql"
    Then the response status code should be 200
    
    
    Scenario: To test existing game in api negative test
    Given I have the base uri
    And I have add game query with game name value "Test Game 01" slug value "Test slug 10" and suplier id value 1
    When I make "POST" request to the end point "/graphql"
    And the response should have the node "errors.message" whose value is "[The slug \"Test Slug 10\" already exists! Cannot add this game...]"

    Scenario: Given I have the base uri
    And I have the query parameter with name "query" and value "{games{id name slug supplier{id name}}}"
    When I make "GET" request to the end point "/graphql"
    Then the response status code should be 200