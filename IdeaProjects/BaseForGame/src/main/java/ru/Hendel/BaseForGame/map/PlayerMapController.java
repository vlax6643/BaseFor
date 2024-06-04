package ru.Hendel.BaseForGame.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlayerMapController {

    @Autowired
    private PlayerMapRepository playerMapRepository;

    @PutMapping("/createMapPlayer")
    public PlayerMap createMapPlayer(@RequestBody PlayerMap map) {
        return playerMapRepository.save(map);
    }

    @GetMapping("/getMapPlayer/{login}")
    public List<PlayerMap> getMapsByPlayerLogin(@PathVariable String login) {
        return playerMapRepository.findByPlayerUsername(login);
    }
}
