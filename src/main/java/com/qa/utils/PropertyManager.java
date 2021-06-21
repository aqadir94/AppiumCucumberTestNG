package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	
	
	TestUtils testUtils=new TestUtils();
	
	public Properties getProperties() {
	
	String filePath=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+
	"resources"+File.separator+"config.properties";
	Properties prop=new Properties();
	FileInputStream fis = null;
	try {
		
		if(prop.isEmpty()) {
		 fis= new FileInputStream(filePath);
		prop.load(fis);
		
		}
		
	} catch (Exception e) {
		
		e.printStackTrace();
		testUtils.log().fatal("Fail to load config properties", e.toString());
	}
	
	finally {
		if(fis!=null) {
			
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
return prop;
}
}