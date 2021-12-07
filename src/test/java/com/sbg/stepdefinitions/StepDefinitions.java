package com.sbg.stepdefinitions;

import com.sbg.utils.PropertiesUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

public class StepDefinitions {

    RequestSpecification requestSpecification = RestAssured.given();
    Response response;

    @Given("I have the base uri")
    public void iHaveTheBaseUri() {
        String baseURI = PropertiesUtil.getInstance().getProperty("base_uri");
        requestSpecification.baseUri(baseURI);
    }

    @And("I have the query parameter with name {string} and value {string}")
    public void iHaveTheQueryParameterWithNameAndValue(String queryParamKey, String queryParamValue) {
    	
        requestSpecification.queryParam(queryParamKey, queryParamValue);
    }

    @When("I make {string} request to the end point {string}")
    public void iMakeRequestToTheEndPoint(String requestType, String endPoint) {
        switch (requestType) {
            case "GET":
                response = requestSpecification.when().get(endPoint);
                break;
            case "POST":
                response = requestSpecification.when().post(endPoint);
                break;
            case "PUT":
                response = requestSpecification.when().put(endPoint);
                break;
            case "DELETE":
                response = requestSpecification.when().delete(endPoint);
                break;
            default:
                throw new IllegalArgumentException("Invalid request type provided '" + requestType + "'");

        }
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        ///System.out.println(response.asString());
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode,expectedStatusCode,"Actual and expected status messages are not matching");
    }

    @And("the response should have the node {string}")
    public void theResponseShouldHaveTheNode(String nodeJsonPath) {
        Object responseJsonObj = response.jsonPath().get(nodeJsonPath);
        Assert.assertNotNull(responseJsonObj,"Expected node with path '"+nodeJsonPath+"' doesn't exist.");
    }

    @And("the response should have the node {string} whose value is {string}")
    public void theResponseShouldHaveTheNodeWhoseValueIs(String nodeJsonPath, String expectedNodeValue) {
        Object responseJsonObj = response.jsonPath().get(nodeJsonPath);
        Assert.assertNotNull(responseJsonObj,"Expected node with path '"+nodeJsonPath+"' doesn't exist.");
        String actualNodeValue = responseJsonObj.toString();
        Assert.assertEquals(actualNodeValue,expectedNodeValue,"Expected and actual node values are not matching.");
    }
    
    @And("the response should have the node {string} whose name is {string}")
    public void the_response_should_have_the_node_whose_name_is(String nodeJsonPath, String expectedNodeName) {
    	Object responseJsonObj = response.jsonPath().get(nodeJsonPath);
        Assert.assertNotNull(responseJsonObj,"Expected node with path '"+nodeJsonPath+"' doesn't exist.");
        String actualNodeName = responseJsonObj.toString();
        Assert.assertEquals(actualNodeName,expectedNodeName,"Expected and  node Names are not matching.");
    }
      
    @Then("the response should have the body {string}")
    public void the_response_should_have_the_body(String expectedMessage) {
    	String actualMessage = response.asString();
    	assertTrue(actualMessage.contains(expectedMessage));
    }
  
   
    }
    
  
    
    
   

