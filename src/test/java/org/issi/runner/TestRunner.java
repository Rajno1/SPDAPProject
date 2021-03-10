package org.issi.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Appfeatures/TC005_SearchMedicarePlans.feature"},
        glue = {"org.issi.stepdefinitions","org.issi.hooks"},
        dryRun = true, // to check mapping make it 'true' (or) to execute your script makesure it is in 'false'
       // tags = "@SearchByApplicantName",
        //tags = "not @regression or @smoke or @sanity",
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                // "timeline:test-output-thread/"
        }
)
public class TestRunner {
}
