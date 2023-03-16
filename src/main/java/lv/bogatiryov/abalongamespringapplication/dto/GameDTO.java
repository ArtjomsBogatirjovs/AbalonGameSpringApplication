package lv.bogatiryov.abalongamespringapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.bogatiryov.abalongamespringapplication.enums.Color;
import lv.bogatiryov.abalongamespringapplication.enums.GameType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private Long id;
    private GameType gameType;
    private Color color;
}
