package com.qa.utils;

public class GlobalParams {

	private static ThreadLocal<String> platformName = new ThreadLocal<String>();
	private static ThreadLocal<String> udid = new ThreadLocal<String>();
	private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
	private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
	private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
	private static ThreadLocal<String> WdaLocalPort = new ThreadLocal<String>();
	private static ThreadLocal<String> WebkitDebugProxyPort = new ThreadLocal<String>();

	public void setplatFormName(String platformName2) {

		platformName.set(platformName2);

	}

	public String getPlatformName() {

		return platformName.get();

	}
	
	public void setUdid(String udid2) {

		udid.set(udid2);

	}

	public String getUdid() {

		return udid.get();

	}
	
	public void setUdeviceName(String deviceName2) {

		deviceName.set(deviceName2);

	}

	public String getdeviceName() {

		return deviceName.get();

	}
	
	public void setSystemPort(String systemPort2) {

		systemPort.set(systemPort2);

	}

	public String getSystemPort() {

		return systemPort.get();

	}
	
	public void setChromeDriverPort(String chromeDriverPort2) {

		chromeDriverPort.set(chromeDriverPort2);

	}

	public String getchromeDriverPort() {

		return chromeDriverPort.get();

	}
	
	public void setWdaLocalPort(String WdaLocalPort2) {

		WdaLocalPort.set(WdaLocalPort2);

	}

	public String getWdaLocalPort() {

		return WdaLocalPort.get();

	}
	
	public void setWebkitDebugProxyPort(String WebkitDebugProxyPort2) {

		WebkitDebugProxyPort.set(WebkitDebugProxyPort2);

	}

	public String getWebkitDebugProxyPort() {

		return WebkitDebugProxyPort.get();

	}
	
	

	public void initializeglobalParams() {
		
		setplatFormName(System.getProperty("platformName","Android")); //passs the value at run time from a Maven command, if a value is not passed the default will be Android
		setUdid(System.getProperty("udid","50584a424e443498"));
		setUdeviceName(System.getProperty("deviceName","Galaxy S9"));
		
		if(getPlatformName().contentEquals("Android")) {
			
			setChromeDriverPort(System.getProperty("chromeDriverPort","11000"));
			setSystemPort(System.getProperty("systemPort","10000"));
		}
		
		else if(getPlatformName().contentEquals("iOS")) {
		
			setWdaLocalPort(System.getProperty("WdaLocalPort","11001"));
			setWebkitDebugProxyPort(System.getProperty("WebkitDebugProxyPort","100001"));
		}
		
		else {
			//System.out.println(getPlatformName());
			throw new IllegalStateException("Invalid platform specified");
			
		}
		
	

	}

}


