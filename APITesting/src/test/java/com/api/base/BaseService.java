package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
	
	protected Response Getreq(String endpoint) {
		
		Response response =  rs.get(endpoint);
		return response;
	}
}
