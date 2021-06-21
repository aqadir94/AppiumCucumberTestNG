package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverManager {
	
	private static ThreadLocal <AppiumDriver> driver=new ThreadLocal<>();
	TestUtils testUtils=new TestUtils();
	
	public void setDriver(AppiumDriver driver2) {
		
		driver.set(driver2);
		
	}
	
	public static AppiumDriver getDriver() {
		
		return driver.get();
		
	}
	
	public void initializeDriver() throws Exception {
		
		AppiumDriver lDriver=null;
		PropertyManager prop=new PropertyManager();
		GlobalParams params=new GlobalParams();
		
		
		try {
			
			if(lDriver==null) {
				
				testUtils.log().info("Initializing driver");
				System.out.println(params.getPlatformName());
				
				if(params.getPlatformName().contentEquals("Android")) {
					
					
					lDriver=new AndroidDriver(new ServerManager().getServer().getUrl(),new CapabilitiesManager().getCap());
					System.out.println("Initializing driver");
					
				}
				
				else if(params.getPlatformName().contentEquals("iOS")) {
					
					lDriver=new IOSDriver(new ServerManager().getServer().getUrl(),new CapabilitiesManager().getCap());
					
				}
				
				if (driver==null) {
					
					throw new Exception("driver is null");
				}
				
				testUtils.log().info("Driver is initialized");
				driver.set(lDriver);
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			testUtils.log().fatal("Driver initializtion failure "+ e.toString());
			throw e;
			
		}
		
		
	}

}
