package com.practice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private String id;
    private String name;
    private int tier;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", tier=" + tier + "]";
	}
}
