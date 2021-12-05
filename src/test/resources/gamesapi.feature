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
    And the response should have the node "data.game.id" whose value is "5"