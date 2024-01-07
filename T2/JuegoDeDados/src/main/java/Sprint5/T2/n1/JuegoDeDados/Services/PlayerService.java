package Sprint5.T2.n1.JuegoDeDados.Services;

import Sprint5.T2.n1.JuegoDeDados.Model.DTO.PlayerDTO;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import Sprint5.T2.n1.JuegoDeDados.Repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private static Long anonymousCounter = 1L;
    private final GameService gameService;
    @Autowired
    private final PlayerRepository playerRepository;


    public PlayerService(GameService gameService, PlayerRepository playerRepository) {
        this.gameService = gameService;
        this.playerRepository = playerRepository;
    }

    public PlayerDTO toDTO (Player player){
        return new PlayerDTO(player);
    }

    public void addPlayer(Player player) {

        // Verificar si el nombre es nulo o está vacío.
        if (player.getName() == null || player.getName().trim().isEmpty()) {
            player.setName("Anónimo" + anonymousCounter);
            anonymousCounter++;
        } else {
            // Obtener el Optional
            Optional<Player> existingPlayerOptional = playerRepository.findPlayerByName(player.getName());

            if (existingPlayerOptional.isPresent()) {
                throw new IllegalStateException("Player with the same name already exists");
            }
        }
        playerRepository.save(player);
    }

    public void updatePlayerName(Long id, String newName) {
        Optional<Player> existingPlayer = playerRepository.findById(id);
        if (existingPlayer.isPresent()) {
            Player updatedPlayer = existingPlayer.get();
            updatedPlayer.setName(newName);
            playerRepository.save(updatedPlayer);
        } else {
            throw new IllegalStateException("Player not found");
        }
    }

    public void playerRollsDice(Long id) {
        gameService.newGameByIdPlayer(playerRepository, id);
    }

    public void playerDeleteGames(Long id) {
        gameService.deleteAllGamesByIdPlayer(playerRepository, id);
    }

    public List<PlayerDTO> getPlayersWithAverage() {
        List<Player> players = playerRepository.findAll();


        return players.stream()
                .map(player -> toDTO(player))
                .collect(Collectors.toList());
    }

    public Map<String, Object> getPlayerGamesById(Long id) {
        if (!playerRepository.existsById(id)){
            throw new EntityNotFoundException("No existe un jugador con el id " + id);
        }
        Player player = playerRepository.getReferenceById(id);

        return gameService.getGamesByPlayer(player);
    }
}
