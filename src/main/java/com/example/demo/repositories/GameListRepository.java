package com.example.demo.repositories;

import com.example.demo.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository <GameList,Long> {
}
