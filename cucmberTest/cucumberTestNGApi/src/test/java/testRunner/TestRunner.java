package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:features/apiTest.feature"},
		glue = "stepDefinition",
		plugin = {
				"pretty",
				"html:target/CucmberReport"
		},
		dryRun = false
	)

public class TestRunner {

	
}
