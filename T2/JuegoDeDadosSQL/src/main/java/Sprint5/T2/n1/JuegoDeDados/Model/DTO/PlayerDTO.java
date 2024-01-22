package Sprint5.T2.n1.JuegoDeDados.Model.DTO;

import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Game;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDTO {

    private String name;
    private String password;
    @JsonIgnore
    private List<Game> games;
    private double average;
    private Set<String> roles;

    public PlayerDTO(Player player) {
        this.name = player.getName();
        this.games = player.getGames();
        this.average = player.calculateWinningAverage();
    }
}
