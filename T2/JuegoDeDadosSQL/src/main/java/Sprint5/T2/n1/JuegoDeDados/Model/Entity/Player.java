package Sprint5.T2.n1.JuegoDeDados.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(unique = true)
    private String name;
    private LocalDate date = LocalDate.now();
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore // Evita que se serialice la lista de juegos cuando se serializa el jugador.
    private List<Game> games;

    public Player() {
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
    
    @Override
    public String toString(){
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
