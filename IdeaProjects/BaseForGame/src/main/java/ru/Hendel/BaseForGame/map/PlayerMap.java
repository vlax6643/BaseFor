package ru.Hendel.BaseForGame.map;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.Hendel.BaseForGame.player.Player;

@Getter
@Setter
@Entity
@Table(name = "maps")
public class PlayerMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "map_name", nullable = false)
    private String mapName;
}
