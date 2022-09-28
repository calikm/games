package com.git.games.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.git.games.model.Game;

//for in memory db just to see how it works
//here we create our own implementation of a data access object interface
//these methods are already created within a CrudRepository interface, so you just need to provide an implementation if needed

@Repository("mockGameDao")
public class MockGameDataAccessService implements GameDao{
	
	private static List<Game> DB = new ArrayList<>();
	

	@Override
	public int insertGame(int id, Game game) {
		DB.add(new Game(id, game.getName(), game.getRating(), game.getGenre()));
		return 1;
	}

	@Override
	public List<Game> selectAllGames() {
		return DB;
	}

	@Override
	public Optional<Game> selectGameById(int id) {
		return DB.stream()
				 .filter(game -> game.getId() == id)
				 .findFirst();
	}

	@Override
	public int deleteGameById(int id) {
		Optional<Game> possibleGame = selectGameById(id);
		if (possibleGame.isEmpty()) {
			return 0;
		}
		DB.remove(possibleGame.get());
		return 1;
	}

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
