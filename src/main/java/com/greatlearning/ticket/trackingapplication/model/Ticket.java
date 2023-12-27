package com.greatlearning.ticket.trackingapplication.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	// DEFAULT CONSTRUCTOR WITHOUT ANY PARAMETER
	public Ticket() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String content;
	private Date createdOn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	// PARAMETERIZED CONSTRUCTOR
	public Ticket(int id, String title, String description, Date createdOn, String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content + ", createdOn=" + createdOn
				+ "]";
	}
}
