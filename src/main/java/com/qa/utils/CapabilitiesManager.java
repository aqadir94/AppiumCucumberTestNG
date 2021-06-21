package com.qa.utils;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilitiesManager {
	
	Properties prop=new PropertyManager().getProperties();
	TestUtils testUtils=new TestUtils();
	GlobalParams params=new GlobalParams();
	
	
	public DesiredCapabilities getCap() {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		try {
			
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getdeviceName());	
		caps.setCapability(MobileCapabilityType.UDID, params.getUdid());
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
	
		
		if(params.getPlatformName().contentEquals("Android")) {
			
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.getProperty("androidAutomationName"));
			caps.setCapability("appPackage", prop.getProperty("androidAppPackage"));
			caps.setCapability("appActivity", prop.getProperty("androidAppActivity"));
			caps.setCapability("systemPort", params.getSystemPort());
			caps.setCapability("chromeDriverPort", params.getchromeDriverPort());
			
			
			String appLocation=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+
			File.separator+"resources"+File.separator+"apps"+File.separator+"Saucelabs.apk";
			
			testUtils.log().info("App url is "+appLocation);
			caps.setCapability(MobileCapabilityType.APP, appLocation);
		}
		
	if(params.getPlatformName().contentEquals("iOS")) {
			
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.getProperty("iOSAutomationName"));
			caps.setCapability("bundleId", prop.getProperty("iOSBundleID"));
			caps.setCapability("wdaLocalPort", prop.getProperty("wdaLocalPort"));
			caps.setCapability("webkitDebugProxyPort", prop.getProperty("webkitDebugProxyPort"));
		
			
			
			String appLocation=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+
			File.separator+"resources"+File.separator+"apps"+File.separator+"Saucelabs.ipa";
			
			testUtils.log().info("App url is "+appLocation);
			caps.setCapability(MobileCapabilityType.APP, appLocation);
		}
		
			
		}
		
		catch(Exception e){
			
			e.printStackTrace();
			testUtils.log().fatal("Failed to load capabilities "+ e.toString());
			throw e; // when you do this it aborts program from running
		}
		
		return caps;
	}

}
