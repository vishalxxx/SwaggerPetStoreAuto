package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class ApiFilter implements Filter {

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		addPetRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		addPetResponse(response);
		return response;
	}

	public void addPetRequest(FilterableRequestSpecification requestSpec) {
		System.out.println("Request Body: " + requestSpec.getBody());
		System.out.println("Request Header: " + requestSpec.getHeaders());
		System.out.println("Request Base URI: " + requestSpec.getBaseUri());
	}
	
	public void addPetResponse(Response response) {
		System.out.println("Request Body: " + response.getBody().prettyPrint());
		System.out.println("Request Header: " + response.getHeaders());
	

	}
	
}
