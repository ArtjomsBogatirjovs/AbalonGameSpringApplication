package lv.bogatiryov.abalongamespringapplication.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class PlayerDTO {
    @NotNull
    private String userName;
    @NotNull
    private String password;
}
