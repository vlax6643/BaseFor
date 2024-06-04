package ru.Hendel.BaseForGame.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.Hendel.BaseForGame.user.User;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping("/getAllPlayers")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @PutMapping("/createPlayerByLogin")
    public Player createPlayerByLogin(@RequestBody Player player) {

        return playerRepository.save(player);
    }

    @DeleteMapping("/deletePlayer/{login}")
    public String deletePlayerByLogin(@PathVariable String login) {
        Player player = playerRepository.findByUsername(login).orElseThrow(() -> new RuntimeException("Player not found"));
        playerRepository.delete(player);
        return "Player deleted successfully";

    }

    @DeleteMapping("/deleteAllPlayers")
    public void deleteAllPlayers(){
         playerRepository.deleteAll();
    }

    @PostMapping("/getPlayer/{login}")
    public Player getPlayerByLogin(@PathVariable String login) {
        return playerRepository.findByUsername(login).orElseThrow(() -> new RuntimeException("Player not found"));
    }
}
