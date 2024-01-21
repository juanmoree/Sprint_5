package Sprint5.T2.n1.JuegoDeDados.Controllers;

import Sprint5.T2.n1.JuegoDeDados.Model.DTO.PlayerDTO;
import Sprint5.T2.n1.JuegoDeDados.Model.DTO.RegisterPlayerDTO;
import Sprint5.T2.n1.JuegoDeDados.Model.ERole;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.RoleEntity;
import Sprint5.T2.n1.JuegoDeDados.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private final PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated @RequestBody RegisterPlayerDTO registerPlayerDTO){
        return playerService.registerPlayer(registerPlayerDTO);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @PutMapping
    @ResponseStatus (HttpStatus.OK)
    public void updatePlayer(@RequestBody Map<String, Object> data) {
        Long playerId = Long.parseLong(data.get("id").toString());
        String newName = data.get("name").toString();
        playerService.updatePlayerName(playerId, newName);
    }

    @GetMapping
    public List<PlayerDTO> allPlayersWithAverage() {
        return playerService.getPlayersWithAverage();
    }

    @GetMapping("/ranking")
    @ResponseStatus (HttpStatus.OK)
    public float averageRankingAllPlayers (){
        return playerService.getAverageRankingPlayers();
    }

    @GetMapping("/ranking/loser")
    @ResponseStatus (HttpStatus.OK)
    public List<PlayerDTO> playerWorseAverage(){
        return playerService.getPlayerWorseAverage();
    }
    @GetMapping("/ranking/winner")
    @ResponseStatus (HttpStatus.OK)
    public List<PlayerDTO> playerBestAverage(){
        return playerService.getPlayerBestAverage();
    }

}
