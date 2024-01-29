package Sprint5.T2.n1.JuegoDeDados.Model.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document ("games")
public class Game {

    @Id
    private String idGame;
    private boolean win;
    private byte dice1;
    private byte dice2;
    @DBRef
    private Player player;

    public Game (){}
    public Game (Player player, byte dice1, byte dice2){
        this.player = player;
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.win = (dice1 + dice2) == 7;
        player.getGames().add(this);
    }
}
