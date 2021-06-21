package com.qa.runners;

import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(plugin = {"pretty", "html:target/Galaxy9/cucumber","summary","de.monochromata.cucumber.report.PrettyReports:target/galaxy9/cucumber-html-reports"},
features={"src/test/resources"},
glue= {"com.qa.stepdef"},
dryRun=false,
monochrome=true,
tags = "@test"

		) 


public class MyTestNGRunnerGalaxy9Test extends RunnerBase {

    

}