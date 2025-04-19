package com.api.model.request;

import java.util.ArrayList;
import java.util.List;

public class AddPetPojo {

	@Override
	public String toString() {
		return "AddPetPojo [id=" + id + ", category=" + category + ", name=" + name + ", photoUrls=" + photoUrls
				+ ", tags=" + tags + ", status=" + status + "]";
	}

	private int id;
	private AddPetPojo(int id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}
	
	public AddPetPojo() {}

	private Category category;
	private String name;
	private List<String> photoUrls;
	private List<Tag> tags;
	private String status;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static class Category {

	

		@Override
		public String toString() {
			return "Category [id=" + id + ", name=" + name + "]";
		}

		int id;
		String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
	}

	public static class Tag {
	
		@Override
		public String toString() {
			return "Tag [id=" + id + ", name=" + name + "]";
		}

		int id;
		String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
	}
	
	public static class Builder{
		private int id;
		private Category category;
		private String name;
		private List<String> photoUrls;
		private List<Tag> tags;
		private String status;
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		public Builder category(Category c) {
			this.category = c;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder photoUrls(List<String> photoUrls) {
			this.photoUrls = photoUrls;
			return this;
		}
		public Builder tags(List<Tag> tags) {
			this.tags = tags;
			return this;
		}
		public Builder status(String status) {
			this.status = status;
			return this;
		}
		
		public AddPetPojo build() {
			
			AddPetPojo ap = new AddPetPojo(id,  category,  name,  photoUrls,  tags,  status);
			return ap;
		}
		
		
	}

}
