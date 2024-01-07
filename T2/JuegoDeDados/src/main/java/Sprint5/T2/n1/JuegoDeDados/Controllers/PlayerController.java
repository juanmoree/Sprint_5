package Sprint5.T2.n1.JuegoDeDados.Controllers;

import Sprint5.T2.n1.JuegoDeDados.Model.DTO.PlayerDTO;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import Sprint5.T2.n1.JuegoDeDados.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @PutMapping
    public void updatePlayer(@RequestBody Map<String, Object> data) {
        Long playerId = Long.parseLong(data.get("id").toString());
        String newName = data.get("name").toString();
        playerService.updatePlayerName(playerId, newName);
    }

    @PostMapping("/{id}/games")
    public ResponseEntity<String> playerRollsDice(@PathVariable Long id) {
        playerService.playerRollsDice(id);
        return new ResponseEntity<>("Tirada realizada con éxito", HttpStatus.OK);
    }

    @DeleteMapping("{id}/games")
    public ResponseEntity<String> playerDeleteGames(@PathVariable Long id) {
        playerService.playerDeleteGames(id);
        return new ResponseEntity<>("Partidas eliminadas con éxito", HttpStatus.OK);
    }

    @GetMapping
    public List<PlayerDTO> allPlayersWithAverage() {
        return playerService.getPlayersWithAverage();
    }

    @GetMapping("{id}/games")
    @ResponseStatus (HttpStatus.OK)
    public Map<String, Object> playerGamesById(@PathVariable Long id){
        return playerService.getPlayerGamesById(id);
    }

    @GetMapping("/ranking")
    @ResponseStatus (HttpStatus.OK)
    public float averageRankingAllPlayers (){
        return playerService.getAverageRankingPlayers();
    }
}
