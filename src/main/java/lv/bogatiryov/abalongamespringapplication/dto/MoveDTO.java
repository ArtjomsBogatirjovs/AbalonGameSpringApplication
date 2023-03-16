package lv.bogatiryov.abalongamespringapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.bogatiryov.abalongamespringapplication.enums.Color;
import lv.bogatiryov.abalongamespringapplication.db.domain.Direction;
import lv.bogatiryov.abalongamespringapplication.db.domain.Field;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoveDTO {
    private Set<Field> fields;
    private Direction direction;
    private Color playerColor;
}
