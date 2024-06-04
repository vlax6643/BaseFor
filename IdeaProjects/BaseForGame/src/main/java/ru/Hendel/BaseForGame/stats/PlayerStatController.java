package ru.Hendel.BaseForGame.stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.Hendel.BaseForGame.map.PlayerMap;
import ru.Hendel.BaseForGame.map.PlayerMapRepository;
import ru.Hendel.BaseForGame.player.Player;
import ru.Hendel.BaseForGame.player.PlayerRepository;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlayerStatController {

    @Autowired
    private PlayerStatRepository playerStatRepository;


    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerMapRepository playerMapRepository;


    @PutMapping("/createStatPlayer")
    public PlayerStat createStatPlayer(@RequestBody PlayerStat stat) {
        Player player = playerRepository.findByUsername(stat.getPlayer().getUsername())
                .orElseThrow(() -> new RuntimeException("Player not found"));
        stat.setPlayer(player);


        if (stat.getMap() != null) {
            PlayerMap map = playerMapRepository.findById(stat.getMap().getId())
                    .orElseThrow(() -> new RuntimeException("Map not found"));
            stat.setMap(map);
        }

        return playerStatRepository.save(stat);
    }

    @GetMapping("/getStatPlayer/{login}")
    public List<PlayerStat> getStatsByPlayerLogin(@PathVariable String login) {
        return playerStatRepository.findByPlayerUsername(login);
    }
}
