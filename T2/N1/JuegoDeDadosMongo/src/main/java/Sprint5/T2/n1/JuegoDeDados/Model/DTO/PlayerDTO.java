package Sprint5.T2.n1.JuegoDeDados.Model.DTO;

import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Game;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
@Data
public class PlayerDTO {

    private String name;
    @JsonIgnore
    private List<Game> games;
    private double average;

    public PlayerDTO(){
    }
    public PlayerDTO(Player player) {
        this.name = player.getName();
        this.games = player.getGames();
        this.average = player.calculateWinningAverage();
    }
}
