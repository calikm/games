package com.git.games.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.git.games.dao.GameDao;
import com.git.games.model.Game;

//not a necessary class, again - consequence of a tutorial, the controller would be enough
//but i like this approach so i left it, divide and conquer, without this the controller class would be more complicated
//not a lot, but still

@Service
public class GameService {
	
	private final GameDao gameDao;
	
	//here using dependency injection we can switch the implementation easily 
	@Autowired
	public GameService(@Qualifier("derby")GameDao gameDao) {
		this.gameDao = gameDao;
	}
	
	public int addGame(Game game) {
		return gameDao.insertGame(game.getId(), game);
	}
	
	public List<Game> getAllGames() {
		return gameDao.selectAllGames();
	}
	
	public Optional<Game> getGameById(int id) {
		return gameDao.selectGameById(id);
	}
	
	public int deleteGame(int id) {
		return gameDao.deleteGameById(id);
	}
	
	public int updateGame(int id, Game newGame) {
		return gameDao.updateGameById(id, newGame);
	}
}
