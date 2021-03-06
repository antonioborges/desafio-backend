package com.spring.blog.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "authors")
public class Author {
	// TODO com os campos id (long auto incremento), name (string) e createdAt
	// (LocalDate), e seus métodos getters, setters, toString, hashCode e equals

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate createdAt;

	public Author() {

	}

	public Author(Long id, String name, LocalDate createdAt) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, createdAt);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Author)) {
			return false;
		}
		Author author = (Author) o;
		return Objects.equals(id, author.id) && Objects.equals(name, author.name)
				&& Objects.equals(createdAt, author.createdAt);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", createdAt=" + createdAt + "]";
	}

}
