package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "C:\\Users\\INDIA\\eclipse-workspace\\awardcucu\\src\\test\\java\\features\\award.feature",
	glue = {"steps"},
	dryRun = false,
	plugin = {"pretty",
			  "html:target/Testreport.html",
			  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
			  }, 
	monochrome = true // console output will be in more readable format
	)

public class awardrunner {

}
