package com.api.base;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.api.model.request.AddPetPojo;

import io.restassured.response.Response;

public class PetService extends BaseService {
	private static final String Base_Path = "/v2";
	
	public Response UploadPetImage(File file, String endpoint, String metadata, String id) {
		
		Response res = PostFile(file, Base_Path+endpoint+'/'+id+ "/uploadImage", metadata);
		return res;
	}
	
	
	public Response AddPet(AddPetPojo payload, String endpoint) {
		Response res = Postreq(payload, Base_Path + endpoint);
		return res;
	}
	
	public Response SearchPetById(String id, String endpoint) {
		
		Response res = Getreq(Base_Path + endpoint + id);
		return res;
	}
	public Response UpdatePet(AddPetPojo payload, String endpoint) {
		Response res = Putreq(payload, Base_Path + endpoint);
		return res;
	}
	public Response FindByStatus(String status, String endpoint) {
		
		Response response = GetreqQuery(status, Base_Path+endpoint);
		return response;
	
	}
	
	
}
