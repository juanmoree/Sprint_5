package Sprint5.T2.n1.JuegoDeDados.Model.DTO;

import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Game;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    @JsonIgnore
    private Player player;
    private byte dice1;
    private byte dice2;
    private boolean win;

    public GameDTO(Player player, Game game) {
        this.dice1 = game.getDice1();
        this.dice2 = game.getDice2();
        this.win = game.isWin();
    }
}
