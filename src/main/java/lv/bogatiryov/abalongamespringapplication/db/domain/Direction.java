package lv.bogatiryov.abalongamespringapplication.db.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Movement move;
    @Column(name = "x")
    private Boolean x;
    @Column(name = "y")
    private Boolean y;
}
