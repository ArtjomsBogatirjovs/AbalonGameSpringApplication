package lv.bogatiryov.abalongamespringapplication.db.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    Abalone player
    Author:Artjoms Bogatirjovs
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "user_name", unique = true, nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    public Player(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
