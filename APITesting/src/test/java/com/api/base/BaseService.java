package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.Map;

import com.api.filters.ApiFilter;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private static final String Base_URI = "https://petstore.swagger.io";
	RequestSpecification rs;
	
	static{
		
		RestAssured.filters(new ApiFilter());
	
	}
	public BaseService() {
		
		rs = RestAssured.given().contentType(ContentType.JSON).baseUri(Base_URI);
		
	}
	
	protected Response Postreq(Object payload, String endpoint) {
		
		Response response =  rs.body(payload).post(endpoint);
		return response;
	}
	protected Response Putreq(Object payload, String endpoint) {
		System.out.println("*********************************************Endpoint is : "+ endpoint);

		Response response =  rs.given().contentType(ContentType.JSON).body(payload).put(endpoint);
		return response;
	}
	
	protected Response Getreq(String endpoint) {
		
		Response response =  rs.get(endpoint);
		return response;
	}
	protected Response PostFile(File file, String endpoint, String metaData ) {
		Response response = rs.given().multiPart("file",file).multiPart("additionalMetadata",metaData).post(endpoint);
		return response;
	}
	
	protected Response GetreqQuery(String status, String endpoint) {
		Response response = rs.given().queryParam("status", status).get(endpoint);
		return response;
		
	}

}
