package Sprint5.T2.n1.JuegoDeDados.Model.DTO;

import Sprint5.T2.n1.JuegoDeDados.Model.Game;
import Sprint5.T2.n1.JuegoDeDados.Model.Player;
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
        this.average = calculateWinningAverage();
    }

    public double calculateWinningAverage(){
        long totalWonGames = getGames().stream().filter(Game::isWin).count();
        long totalGames = getGames().size();

        if (totalGames == 0){
            return 0.0;
        }
        return (double) totalWonGames / totalGames * 100;
    }


}
