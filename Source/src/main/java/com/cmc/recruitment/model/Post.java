package com.cmc.recruitment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "content", nullable = false)
	private String content;

	public Post() {}
	public Post(long _id, String _title, String _content) {
		this.id = _id;
		this.title = _title;
		this.content = _content;
	}
	
	public long getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}

	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}

}
