package com.sbg.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/"},glue = {"com/sbg/stepdefinitions"})
public class TestRunner extends AbstractTestNGCucumberTests {


}
