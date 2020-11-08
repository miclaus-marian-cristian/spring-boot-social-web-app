package com.miclaus.socialwebapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "Content")
	private String text;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedTime;
	
	@PrePersist
	public void onCreate() {
		if(addedTime == null)
			addedTime = new Date();
	}
	
	public Status() {}
	
	public Status(String text) {
		this.text = text;
	}
	
	public Status(String text, Date addedTime) {
		super();
		this.text = text;
		this.addedTime = addedTime;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getAddedTime() {
		return addedTime;
	}
	public void setAddedTime(Date addedTime) {
		this.addedTime = addedTime;
	}
	
	@Override
	public String toString() {
		return "Status [id=" + id + ", text=" + text + ", addedTime=" + addedTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Status)) {
			return false;
		}
		Status other = (Status) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	
	
}
