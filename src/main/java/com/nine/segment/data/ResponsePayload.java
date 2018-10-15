package com.nine.segment.data;

/**
 * Response Payload POJO, temporally hold the data.
 */
public class ResponsePayload {
	
	private String image;
	private String slug;
	private String title;
	
	public ResponsePayload() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponsePayload(String image, String slug, String title) {
		super();
		this.image = image;
		this.slug = slug;
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
