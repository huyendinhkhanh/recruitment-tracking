package com.cmc.recruitment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
	@Id
	@Column(name = "imageId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long imageId;

	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "description", nullable = true)
	private String description;

	public Image() {
		super();
	}

	public Image(long imageId, String url, String description) {
		super();
		this.imageId = imageId;
		this.url = url;
		this.description = description;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
