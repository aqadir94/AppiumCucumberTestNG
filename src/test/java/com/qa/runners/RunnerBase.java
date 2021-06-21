package com.qa.runners;

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

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

public class RunnerBase {

	 private ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner=new ThreadLocal<>();
	 
	 
	 public TestNGCucumberRunner getRunner() {
		 
		 return testNGCucumberRunner.get();
		 
	 }
	 
	 public void setRunner(TestNGCucumberRunner testNGCucumberRunner2) {
		 
		 
		 testNGCucumberRunner.set(testNGCucumberRunner2);
		 
	 }
	 

	    @Parameters({"udid","emulator","platformName","platformVersion","deviceName","systemPort","chromeDriverPort"})
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass(String udid,@Optional String emulator,String platformName,@Optional String platformVersion ,String deviceName,String systemPort,String chromeDriverPort ) throws Exception {
	    	ThreadContext.put("ROUTINGKEY", platformName+"_"+deviceName);
	    	GlobalParams params=new GlobalParams();
	    	
	    	params.setUdid(udid);
	    	params.setplatFormName(platformName);
	    	params.setUdeviceName(deviceName);
	    	
	    	
	    	if(platformName.contentEquals("Android")) {
	    		
	    		params.setChromeDriverPort(chromeDriverPort);
	    		params.setSystemPort(systemPort);
	    		
	    	}
	    	
	    	else if(platformName.contentEquals("ios")) {
	    		
	    		
	    	}
	    	
	    	else {
	    		
	    		System.out.println("Incorrect platform specified");
	    		throw new IllegalArgumentException();
	    		
	    	}
	    	
	    
			new ServerManager().startServer();
			new DriverManager().initializeDriver();
	    	
	    	setRunner(new TestNGCucumberRunner(this.getClass()));
	    	
	    }

	    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.get().runScenario(pickle.getPickle());
	    }

	    @DataProvider
	    public Object[][] scenarios() {
	        return testNGCucumberRunner.get().provideScenarios();
	    }

	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() {
	    	
	    	DriverManager driverManager=new DriverManager();
			if (driverManager.getDriver()!=null) {
				
				driverManager.getDriver().quit();
				driverManager.setDriver(null);
				
			}
			
			ServerManager serverManager=new ServerManager();
			 if(serverManager.getServer()!=null) {
				 
				 serverManager.getServer().stop();
				 
			 }
	    	
			 if(testNGCucumberRunner!=null) {
	    	
	        testNGCucumberRunner.get().finish();
	        
			 }
	    }
}
