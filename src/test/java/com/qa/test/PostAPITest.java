package com.qa.test;

import org.testng.annotations.BeforeMethod;

import com.qa.base.TestBase;

public class PostAPITest extends TestBase{
	
	public TestBase testbase;
	String ServiceURL;
	String URL;
	String apiURL;
	
	@BeforeMethod
	
	public void setup() {
		
		testbase = new TestBase();
		ServiceURL = prop.getProperty("URL");
		apiURL = prop.getProperty("ServiceURL");
		URL = ServiceURL + apiURL;
	}

}
