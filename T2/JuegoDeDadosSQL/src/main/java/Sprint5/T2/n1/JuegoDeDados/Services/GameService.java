package Sprint5.T2.n1.JuegoDeDados.Services;

import Sprint5.T2.n1.JuegoDeDados.Controllers.Exception.NoGamesFoundException;
import Sprint5.T2.n1.JuegoDeDados.Model.DTO.GameDTO;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Game;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import Sprint5.T2.n1.JuegoDeDados.Repository.GameRepository;
import Sprint5.T2.n1.JuegoDeDados.Repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameDTO toDTO(Player player, Game game) {
        return new GameDTO(player, game);
    }

    public void newGameByIdPlayer(PlayerRepository playerRepository, Long id) {
        Optional<Player> existingPlayerOptional = playerRepository.findById(id);

        if (existingPlayerOptional.isPresent()) {
            Player existingPlayer = existingPlayerOptional.get();
            byte dice1 = rolldice();
            byte dice2 = rolldice();

            Game game = new Game(existingPlayer, dice1, dice2);

            existingPlayer.getGames().add(game);
            gameRepository.save(game);
        } else {
            throw new EntityNotFoundException("Jugador no encontrado");
        }
    }

    private byte rolldice() {
        return (byte) (Math.random() * 6 + 1);
    }

    public void deleteAllGamesByIdPlayer(PlayerRepository playerRepository, Long id) {
        Optional<Player> existingPlayer = playerRepository.findById(id);
        if (existingPlayer.isPresent()) {
            if (existingPlayer.get().getGames().isEmpty()) {
                throw new IllegalStateException("No hay partidas que eliminar");
            }
            gameRepository.deleteAllInBatch(existingPlayer.get().getGames());
        } else {
            throw new IllegalStateException("Jugador no encontrado");
        }
    }

    public Map<String, Object> getGamesByPlayer(Player player) {

        if (player.getGames().isEmpty()){
            throw new NoGamesFoundException(player.getName());
        }

        Map<String, Object> response = new HashMap<>();

        List<GameDTO> games = player.getGames().stream()
                .map(game -> toDTO(player, game))
                .toList();

        response.put("name", player.getName());
        response.put("average", player.calculateWinningAverage());
        response.put("games", games);

        return response;
    }
}
