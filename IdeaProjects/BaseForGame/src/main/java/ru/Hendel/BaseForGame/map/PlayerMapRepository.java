package ru.Hendel.BaseForGame.map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Hendel.BaseForGame.map.PlayerMap;

import java.util.List;

@Repository
public interface PlayerMapRepository extends JpaRepository<PlayerMap, Long> {
    List<PlayerMap> findByPlayerUsername(String username);
}