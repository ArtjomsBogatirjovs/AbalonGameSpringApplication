package lv.bogatiryov.abalongamespringapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.bogatiryov.abalongamespringapplication.db.domain.Direction;
import lv.bogatiryov.abalongamespringapplication.db.domain.Field;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMoveDTO {
    @NotNull
    Set<Field> fields;
    @NotNull
    Direction direction;
}
