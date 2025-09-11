package com.example.demo.services;

import com.example.demo.DTO.GameDTO;
import com.example.demo.DTO.GameMinDTO;
import com.example.demo.entities.Game;
import com.example.demo.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;



    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll()
    {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
     public GameDTO findById(Long id)
    {
       Game result = gameRepository.findById(id).get();
       return new GameDTO(result);
    }

    public Game postGame(Game game)
    {
        return gameRepository.save(game);
    }


}
