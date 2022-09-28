package com.git.games.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "game2")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//this used to be a UUID but spring requires something specific to handle it if you want to create an SQL statement
	//and use it in an external (not embedded) database - a TODO in the future
	private final int id;
	@Column
	private final String name;
	@Column
	private final int rating;
	@Column
	private final String genre;
	
	public Game() {
		id = 0;
		name = "";
		rating = 0;
		genre = "";
	}
	
	public Game(@JsonProperty("id") int id, 
				@JsonProperty("name") String name, 
				@JsonProperty("rating") int rating, 
				@JsonProperty("genre") String genre) {
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getRating() {
		return rating;
	}

	public String getGenre() {
		return genre;
	}
	
	

}
