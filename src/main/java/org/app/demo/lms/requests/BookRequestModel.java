package org.app.demo.lms.requests;

public class BookRequestModel {
	
	private int id;
	
	private String name;
	
	private String authorName;

	private int categoryId;

	public BookRequestModel() {
	
	}
	public BookRequestModel(int id, String name, String authorName, int categoryId) {
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.categoryId = categoryId;
	}

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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Override
	public String toString() {
		return "BookRequestModel [id=" + id + " + name=" + name + ", authorName=" + authorName + ", categoryId="
				+ categoryId + "]";
	}
}
