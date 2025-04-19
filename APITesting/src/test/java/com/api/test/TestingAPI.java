package com.api.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.PetService;

import com.api.model.request.AddPetPojo;
import com.api.model.request.AddPetPojo.*;

import io.restassured.response.Response;

@Listeners(com.api.liteners.ApiListeners.class)
public class TestingAPI {

	@Test(groups="sanity")

	
	public void addpetpositive() {
		String endpoint = "/pet";
		Category cat = new Category();
		cat.setId(100);
		cat.setName("Dog");
		Tag tag = new Tag();
		tag.setId(87);
		tag.setName("New Arrival");
		AddPetPojo ap = new AddPetPojo();
		ap.setCategory(cat);
		ap.setId(56);
		ap.setTags(Arrays.asList(tag));
		ap.setPhotoUrls(Arrays.asList("https://wwww.google.com"));
		ap.setStatus("Avaialable");
		System.out.println("Request: "+ap);
		Response response =	new PetService().AddPet(ap, endpoint);
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test
	public void searchpetbyidpositive() {
		String endpoint = "/pet/";
		String id = "12";
		Response response = new PetService().SearchPetById(id, endpoint);
		response.prettyPrint();
		AddPetPojo ap = response.as(AddPetPojo.class);
		System.out.println(ap.getCategory());
		System.out.println(ap.getStatus());
	}
	
	@Test
	public void addpetwithbuilder() {
		String endpoint = "/pet";
		Category c = new Category();
		c.setId(87);
		c.setName("Animal");
		Tag tag = new Tag();
		tag.setId(56);
		tag.setName("AnimalTag");
		
		AddPetPojo ap = new AddPetPojo.Builder().id(99).name("dog").status("Not Avaialable").category(c).tags(Arrays.asList(tag)).photoUrls(Arrays.asList("house.com")).build();
		
		Response response = new PetService().AddPet(ap, endpoint);
		response.prettyPrint();
		
	}
}
