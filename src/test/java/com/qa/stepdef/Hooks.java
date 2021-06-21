package com.qa.stepdef;

import java.io.IOException;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.VideoManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void initialize() throws Exception {
		
		
		/*
		 * GlobalParams gParams=new GlobalParams(); gParams.initializeglobalParams();
		 * 
		 * ThreadContext.put("ROUTINGKEY",
		 * gParams.getPlatformName()+"_"+gParams.getdeviceName()); new
		 * ServerManager().startServer(); new DriverManager().initializeDriver();
		 */
		new VideoManager().startRecording();
		
		
	}
	
	
	@After
	public void quit(Scenario scenario) throws Exception {
		
		if(scenario.isFailed()) {
			
			
			byte[] screenshot= DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			
			
		}
		
		new VideoManager().stopRecording(scenario.getName());
		
		/*
		 * DriverManager driverManager=new DriverManager(); if
		 * (driverManager.getDriver()!=null) {
		 * 
		 * driverManager.getDriver().quit(); driverManager.setDriver(null);
		 * 
		 * }
		 * 
		 * ServerManager serverManager=new ServerManager();
		 * if(serverManager.getServer()!=null) {
		 * 
		 * serverManager.getServer().stop();
		 * 
		 * }
		 */
	}

}
