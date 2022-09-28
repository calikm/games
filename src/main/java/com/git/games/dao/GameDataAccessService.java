package com.git.games.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.git.games.model.Game;

//for the actual db connection to apache derby
//i deliberately left the ridiculous int returning int when it could just be a string since its already printing something
//why? to show the learning curve and how easy it is to overlook simple things when youre doing tutorials
//actually doing something makes you think - tutorials hand everything on a plate which can result in something like this

@Repository("derby")
public class GameDataAccessService implements GameDao {

	private static List<Game> DB = new ArrayList<>();
	
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public int insertGame(int id,Game game) {
		String queryGame = "insert into game2 (id, name, rating, genre) values (?,?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(queryGame, game.getId(), game.getName(), game.getRating(), game.getGenre());
		System.out.println("Inserted into game2 Table Successfully");
		//this quite obviously should be implemented f.e. returning a string - consequence of a tutorial
		return 1;
	}
	//TODO implement for external DB
	@Override
	public List<Game> selectAllGames() {
		return DB;
	}
	//TODO implement for external DB
	@Override
	public Optional<Game> selectGameById(int id) {
		return DB.stream()
				 .filter(game -> game.getId() == id)
				 .findFirst();
	}
	//TODO implement for external DB
	@Override
	public int deleteGameById(int id) {
		Optional<Game> possibleGame = selectGameById(id);
		if (possibleGame.isEmpty()) {
			return 0;
		}
		DB.remove(possibleGame.get());
		return 1;
	}
	//TODO implement for external DB
	@Override
	public int updateGameById(int id, Game gameUpdate) {
		return selectGameById(id)
				.map(game -> {
					int indexOfGameToUpdate = DB.indexOf(game);
					if (indexOfGameToUpdate >= 0) {
						DB.set(indexOfGameToUpdate, new Game(id, gameUpdate.getName(), gameUpdate.getRating(), gameUpdate.getGenre()));
						return 1;
					}
					return 0;
					
				})
				.orElse(0);
	}



}
