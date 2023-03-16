package lv.bogatiryov.abalongamespringapplication.db.domain;

/*
    Class storage for gameplay
    Author:Artjoms Bogatirjovs
 */

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.bogatiryov.abalongamespringapplication.enums.Color;
import lv.bogatiryov.abalongamespringapplication.enums.GameStatus;
import lv.bogatiryov.abalongamespringapplication.enums.GameType;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "games")
public class Gameplay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "first_player_id", nullable = false)
    private Player playerOne;
    @ManyToOne
    @JoinColumn(name = "second_player_id")
    private Player playerTwo;
    @OneToOne
    private Board board;
    @Enumerated(EnumType.STRING)
    private Color firstPlayerColor;
    @Enumerated(EnumType.STRING)
    private GameType gameType;
    @Enumerated(EnumType.STRING)
    private GameStatus status;
    @Column(name = "created", nullable = false)
    private Date created;
}
