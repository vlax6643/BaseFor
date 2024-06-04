package ru.Hendel.BaseForGame.player;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.Hendel.BaseForGame.user.User;

@Getter
@Setter
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "username")
    private String username;
}