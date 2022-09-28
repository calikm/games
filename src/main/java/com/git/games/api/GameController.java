package com.git.games.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.games.model.Game;
import com.git.games.service.GameService;

@RequestMapping("/api/ver1/game")
@RestController
public class GameController {
	
	private final GameService gameService;

	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@PostMapping
	public void addGame(@RequestBody Game game) {
		gameService.addGame(game);
	}
	
	@GetMapping
	public List<Game> getAllGames() {
		return gameService.getAllGames();
	}
	
	@GetMapping(path = "{id}")
	public Game getGameById(@PathVariable("id") int id) {
		return gameService.getGameById(id)
				.orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteGameById(@PathVariable("id") int id) {
		gameService.deleteGame(id);
	}
	
	@PutMapping(path = "{id}")
	public void updateGame(@PathVariable("id") int id, @RequestBody Game gameToUpdate) {
		gameService.updateGame(id, gameToUpdate);
	}

}
