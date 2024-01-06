package Sprint5.T2.n1.JuegoDeDados.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Game> games;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.games = new ArrayList<>();
    }
}
