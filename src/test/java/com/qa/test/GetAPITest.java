package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;


public class GetAPITest extends TestBase {

	TestBase testbase;
	String ServiceURL;
	String URL;
	String apiURL;
	RestClient restclient;
	


	@BeforeMethod
	public void setup() {

		testbase = new TestBase();
		ServiceURL = prop.getProperty("URL");
		apiURL = prop.getProperty("ServiceURL");
		URL = ServiceURL + apiURL;

	}

	@Test
public void GetTest() throws ClientProtocolException, IOException {

		restclient = new RestClient();
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
	
		headerMap.put("Content-type", "application/json");
		
		CloseableHttpResponse httpresponse= restclient.get(URL, headerMap);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		
		System.out.println("The status code======>" +statuscode);
		
		Assert.assertEquals(statuscode, Response_status_success, "status code is not 200");
	
		
		String responsestring = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		
		JSONObject jsonresponse= new JSONObject(responsestring);
		
		System.out.println("The JSON from response======>" +jsonresponse);
		
		
		Header[] headerarray= httpresponse.getAllHeaders();
		
		HashMap<String, String> allheader = new HashMap<String, String>();
		
		for ( Header headers: headerarray) {
			
			allheader.put(headers.getName(), headers.getValue());
			
			
			
		}
		System.out.println("The Header details are ======>" +allheader);	
		
		
	}
	
}
