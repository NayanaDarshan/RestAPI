package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	
	public int Response_status_success =200;
	
	public TestBase() {
		
		prop = new Properties();
		
		
		try {
			FileInputStream	input = new FileInputStream("C:\\Users\\nayana.raghu\\eclipse-workspace\\RestAPI\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
