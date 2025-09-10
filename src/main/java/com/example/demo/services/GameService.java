package com.example.demo.services;

import com.example.demo.DTO.GameDTO;
import com.example.demo.DTO.GameMinDTO;
import com.example.demo.entities.Game;
import com.example.demo.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll()
    {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

     public GameDTO findById(Long id)
    {
       Game game = gameRepository.findById(id).get();
       GameDTO dto = new GameDTO(game);
       return dto;
    }

    public Game postGame(Game game)
    {
        return gameRepository.save(game);
    }
}
