package com.qa.intro_project.data.entity;

import java.sql.Date;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

// Spring has a 'spring-boot-starter-validation' module which transitively includes
// the 'hibernate-validator' dependency. This can be used to apply validation annotations
// to data transfer or domain objects.
// 
// The preferred method is to annotate your fields with validation attributes, but you
// can annotate methods. Do not do both to avoid unnecessarily validating twice.
//
// Validation must be triggered via the @Valid annotation, see `UserController -> createUser()`.
//
// Validation annotations include:
// - @Email            Applies strict email validation according to the Bean validation provider
// - @NotBlank         The field must not be null and contain at least 1 non-whitespace character
// - @Min @Max         Used to specify the minimum and maximum ranges of a numeric value respectively (inclusive)
// - @Past @Future     Used to specify that a date should be in the past or the future respectively
// - @PastOrPresent    Specifies that the date should be in the past or now
// - @FutureOrPresent  Specifies that the date should be in the future or now
// - @Pattern          Use to provide a regex pattern

public class User {

	private int id;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 16, message = "Username must have at least 2 characters, but no more than 16")
	private String username;

	// TODO: Add 3 new fields to the User class, with appropriate validation
	// annotations applied to each
	
	@PastOrPresent
	private Date createdAt;
	
	@Email
	private String email;
	
	@Min(18)
	@Max(60)
	private int age;

	@Override
	public int hashCode() {
		return Objects.hash(age, createdAt, email, id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(createdAt, other.createdAt) && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(username, other.username);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User() {

	}

	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}

}
