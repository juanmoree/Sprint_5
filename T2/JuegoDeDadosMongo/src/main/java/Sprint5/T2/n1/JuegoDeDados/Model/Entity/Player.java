package Sprint5.T2.n1.JuegoDeDados.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "players")
public class Player {

    @Id
    private String id;
    private String name;
    private LocalDate date = LocalDate.now();
    //@JsonIgnore // Evita que se serialice la lista de juegos cuando se serializa el jugador.
    @DBRef
    private List<Game> games;

    public Player() {
        this.games = new ArrayList<>();
    }
    public Player(String name) {
        this.name = name;
        this.games = new ArrayList<>();
    }

    public double calculateWinningAverage(){
        long totalWonGames = getGames().stream().filter(Game::isWin).count();
        long totalGames = getGames().size();

        if (totalGames == 0){
            return 0.0;
        }
        return (double) totalWonGames / totalGames * 100;
    }
/*
    @Override
    public String toString(){
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }*/
}
