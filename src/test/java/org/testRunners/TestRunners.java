package org.testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/org.features/features/LoginPage.feature",
                           glue={"org.StepDefinition"},monochrome=true)

public class TestRunners {

}
