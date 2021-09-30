package io.github.morbidreich.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="category_description")
public class CategoryDescription {
	@Id
	int id;
	String description;

	
	
	public CategoryDescription() {
	}
	
	public CategoryDescription(String description) {
	
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CategoryDescription [id=" + id + ", description=" + description + "]";
	}
	
	

}
