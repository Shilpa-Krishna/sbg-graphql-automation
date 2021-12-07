Feature: To test Games GraphQL api

  Scenario: To test get all games api
    Given I have the base uri
    And I have the query parameter with name "query" and value "{game(id:1){id name slug supplier{id name}}}"
    When I make "GET" request to the end point "/graphql"
    Then the response status code should be 200
    And the response should have the node "data.game"
    And the response should have the node "data.game.id"
    And the response should have the node "data.game.name"
    And the response should have the node "data.game.slug"
    And the response should have the node "data.game.supplier"
    And the response should have the node "data.game.supplier.id"
    And the response should have the node "data.game.supplier.name"
    And the response should have the node "data.game.id" whose value is "1"
    And the response should have the node "data.game.name" whose name is "Random Game"
    And the response should have the node "data.game.slug" whose name is "random-game"
    And the response should have the node "data.game.supplier.id" whose name is "1"
    And the response should have the node "data.game.supplier.name" whose name is "Greeny's Games"
    
    
    Scenario: To test get all games api neagative test case
    Given I have the base uri
    And I have the query parameter with name "query" and value "{game(id:10){id name slug supplier{id name}}}"
    When I make "GET" request to the end point "/graphql"
    Then the response status code should be 200 
    And the response should have the body "Cannot return null for non-nullable field Game.id."
    
    Scenario: To test bad request in api
    Given I have the base uri
    And I have the query parameter with name "query" and value "{game(id:1){id name slug supplier{id name}}"
    When I make "GET" request to the end point "/graphql"
    Then the response status code should be 400
    
    Scenario: To test get all games api node values neagative test case
    Given I have the base uri
    And I have the query parameter with name "query" and value "{game(id:1){id name slug supplier{id name}}}"
    When I make "GET" request to the end point "/graphql"
    Then the response status code should be 200
    And the response should have the node "data.game.id" whose value is "5"
    And the response should have the node "data.game.name" whose name is "Random Game1"
    And the response should have the node "data.game.slug" whose name is "random-game1"
    And the response should have the node "data.game.supplier.id" whose name is "12"
    And the response should have the node "data.game.supplier.name" whose name is "Greeny's Games1" 
    
    
    
   
    

   