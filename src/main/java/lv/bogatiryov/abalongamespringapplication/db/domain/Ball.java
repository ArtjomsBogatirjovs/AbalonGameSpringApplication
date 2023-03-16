package lv.bogatiryov.abalongamespringapplication.db.domain;

import javax.persistence.*;
import lombok.*;
import lv.bogatiryov.abalongamespringapplication.enums.Color;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
public class Ball {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Enumerated(EnumType.STRING)
    private Color color;

    public Ball(Color color) {
        this.color = color;
    }
}
