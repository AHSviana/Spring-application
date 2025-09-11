package com.example.demo.services;

import com.example.demo.DTO.GameListDTO;
import com.example.demo.DTO.GameMinDTO;
import com.example.demo.entities.Game;
import com.example.demo.entities.GameList;
import com.example.demo.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll()
    {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> listdto = result.stream().map(x -> new GameListDTO(x)).toList();
        return listdto;
    }
}
