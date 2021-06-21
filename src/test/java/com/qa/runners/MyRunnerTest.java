package com.qa.runners;

import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber","summary","de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"},
features={"src/test/resources"},
glue= {"com.qa.stepdef"},
snippets = SnippetType.CAMELCASE,
dryRun=false,
monochrome=true,
tags = "@test"

		) 

public class MyRunnerTest {


	@BeforeClass
	public static void initialize() throws Exception {
		
		GlobalParams gParams=new GlobalParams();
		gParams.initializeglobalParams();
		
		ThreadContext.put("ROUTINGKEY", gParams.getPlatformName()+"_"+gParams.getdeviceName());
		new ServerManager().startServer();
		new DriverManager().initializeDriver();
	}
	
	
	@AfterClass
	public static void quit() {
		
		DriverManager driverManager=new DriverManager();
		if (driverManager.getDriver()!=null) {
			
			driverManager.getDriver().quit();
			driverManager.setDriver(null);
			
		}
		
		ServerManager serverManager=new ServerManager();
		 if(serverManager.getServer()!=null) {
			 
			 serverManager.getServer().stop();
			 
		 }
		
	}
	
}
