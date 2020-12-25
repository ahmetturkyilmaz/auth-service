package com.fitness.authservice.payload.response;

import java.util.List;

public class JwtResponse {
	private String accessToken;
	private String type = "Bearer";
	private Long id;
	private String email;
	private String name;
	private String surname;
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String email, String name, String surname, List<String> roles) {
		this.accessToken = accessToken;
		this.id = id;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.roles = roles;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
