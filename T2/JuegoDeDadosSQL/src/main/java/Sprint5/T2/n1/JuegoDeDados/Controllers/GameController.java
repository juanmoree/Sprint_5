package Sprint5.T2.n1.JuegoDeDados.Controllers;

import Sprint5.T2.n1.JuegoDeDados.Repository.PlayerRepository;
import Sprint5.T2.n1.JuegoDeDados.Services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/players")
public class GameController {

    private final GameService gameService;

    @PostMapping("/{id}/games")
    public ResponseEntity<String> playerRollsDice(@PathVariable Long id) {
        gameService.playerRollsDice(id);
        return new ResponseEntity<>("Tirada realizada con éxito", HttpStatus.OK);
    }

    @DeleteMapping("{id}/games")
    public ResponseEntity<String> playerDeleteGames(@PathVariable Long id) {
        gameService.playerDeleteGames(id);
        return new ResponseEntity<>("Partidas eliminadas con éxito", HttpStatus.OK);
    }

    @GetMapping("{id}/games")
    @ResponseStatus (HttpStatus.OK)
    public Map<String, Object> playerGamesById(@PathVariable Long id){
        return gameService.getPlayerGamesById(id);
    }
}
