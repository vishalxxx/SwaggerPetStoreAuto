package com.api.base;

import com.api.model.request.AddPetPojo;

import io.restassured.response.Response;

public class PetService extends BaseService {
	private static final String Base_Path = "/v2";
	
	
	public Response AddPet(AddPetPojo payload, String endpoint) {
		Response res = Postreq(payload, Base_Path + endpoint);
		return res;
	}
	
	public Response SearchPetById(String id, String endpoint) {
		
		Response res = Getreq(Base_Path + endpoint + id);
		return res;
	}
}
