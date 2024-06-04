package ru.Hendel.BaseForGame.stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerStatRepository extends JpaRepository<PlayerStat, Long> {
    List<PlayerStat> findByPlayerUsername(String username);
}