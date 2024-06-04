package ru.Hendel.BaseForGame.stats;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.Hendel.BaseForGame.map.PlayerMap;
import ru.Hendel.BaseForGame.player.Player;

import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "player_stats")
public class PlayerStat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;


    @Column(name = "win")
    private Boolean win;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private PlayerMap map;
}
