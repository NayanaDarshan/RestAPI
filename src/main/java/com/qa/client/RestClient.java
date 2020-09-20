package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.*;

public class RestClient {
	
	//GET Method without headers

	public CloseableHttpResponse get( String url) throws ClientProtocolException, IOException {
		
	CloseableHttpClient Httpclient = HttpClients.createDefault();
	HttpGet httpget = new HttpGet(url);// http get request
	CloseableHttpResponse httpresponse =Httpclient.execute(httpget);//hit the url
	
	return httpresponse;
	}
	
	//GET Method with headers
      
	public CloseableHttpResponse get(String url, HashMap<String, String> headermap) throws ClientProtocolException, IOException {
		
	CloseableHttpClient Httpclient = HttpClients.createDefault();
	HttpGet httpget = new HttpGet(url);// http get request
	
	for (Map.Entry<String, String> entry: headermap.entrySet()) {
		httpget.addHeader(entry.getKey(), entry.getValue());
		
	}
	
	
	
	CloseableHttpResponse httpresponse =Httpclient.execute(httpget);//hit the url
	
	return httpresponse;
	
	
	//POST Method
	
	public CloseableHttpResponse post(String url1, String entityString, HashMap<String, String> headerMap) {
		
		
		CloseableHttpClient Httpclient1= HttpClients.createDefault();
		
		HttpPost httppost = new HttpPost(url1);
		httppost.setEntity(new StringEntity(entityString));
		
		for(Map.Entry<String, String> entry : headerMap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());	
		}
		
	CloseableHttpResponse postresponse=	Httpclient1.execute(httppost);
	
		return postresponse;
	}
	
	
	}
	
}