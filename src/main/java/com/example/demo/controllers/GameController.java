package com.example.demo.controllers;

import com.example.demo.DTO.GameDTO;
import com.example.demo.DTO.GameMinDTO;
import com.example.demo.entities.Game;
import com.example.demo.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")

public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll()
    {
         List<GameMinDTO> result = gameService.findAll();
         return result;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public GameDTO findById(@PathVariable Long id)
    {
        return gameService.findById(id);
    }

    @PostMapping
    @RequestMapping("/games/newgame")
    public Game postGame(Game game)
    {
        return gameService.postGame(game);
    }

}
