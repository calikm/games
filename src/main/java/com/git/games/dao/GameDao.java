package com.git.games.dao;

import java.util.List;
import java.util.Optional;

import com.git.games.model.Game;

public interface GameDao {
	
	int insertGame(int id, Game game);
	
	//default method also a consequence of a tutorial - it would work without it but probably in an enterprise app it would be useful in certain cases
	default int insertGame(Game game) {
		int id = 1;
		return insertGame(id, game);
	}
	
	List<Game> selectAllGames();
	
	Optional<Game> selectGameById(int id);
	
	int deleteGameById(int id);
	
	int updateGameById(int id, Game game);
}
