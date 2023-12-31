package Sprint5.T2.n1.JuegoDeDados.Services;

import Sprint5.T2.n1.JuegoDeDados.Model.DTO.PlayerDTO;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import Sprint5.T2.n1.JuegoDeDados.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public PlayerDTO toDTO(Player player) {
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

    public void updatePlayerName(String id, String newName) {
        Optional<Player> existingPlayer = playerRepository.findById(id);
        Optional<Player> existingName = playerRepository.findPlayerByName(newName);
        if (existingPlayer.isPresent()) {
            if (!existingName.isPresent()) {
                Player updatedPlayer = existingPlayer.get();
                updatedPlayer.setName(newName);
                playerRepository.save(updatedPlayer);
            } else {
                throw new IllegalStateException("Name already exists");
            }
        } else {
            throw new IllegalStateException("Player not found");
        }
    }

    public void playerRollsDice(String id) {
        gameService.newGameByIdPlayer(playerRepository, id);
    }

    public void playerDeleteGames(String id) {
        gameService.deleteAllGamesByIdPlayer(playerRepository, id);
    }

    public List<PlayerDTO> getPlayersWithAverage() {
        List<Player> players = playerRepository.findAll();


        return players.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Map<String, Object> getPlayerGamesById(String id) {
        if (!playerRepository.existsById(id)) {
            throw new NoSuchElementException("No existe un jugador con el id " + id);
        }
        Optional<Player> optionalPlayer = playerRepository.findById(id);

        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            return gameService.getGamesByPlayer(player);
        }
        return null;
    }

    public float getAverageRankingPlayers() {
        if (playerRepository == null) {
            throw new NoSuchElementException("No existe ningún jugador");
        }

        List<Player> players = playerRepository.findAll();
        float count = 0;
        for (Player x : players) {
            count += (float) x.calculateWinningAverage();
        }
        return count / players.size();
    }

    // Retorna lista por si hay mas de un jugador con el mismo promedio.
    public List<PlayerDTO> getPlayerWorseAverage() {
        if (playerRepository == null) {
            throw new NoSuchElementException("No existe ningún jugador");
        }

        Optional<Player> playerWorseAverage = playerRepository.findAll().stream()
                .min(Comparator.comparingDouble(Player::calculateWinningAverage));

        if (playerWorseAverage.isPresent()) {
            double worseAverage = playerWorseAverage.get().calculateWinningAverage();
            List<Player> sameAverage = playerRepository.findAll().stream()
                    .filter(player -> player.calculateWinningAverage() == worseAverage)
                    .toList();
            return sameAverage.stream().map(this::toDTO).toList();
        }
        return null;
    }

    // Retorna lista por si hay mas de un jugador con el mismo promedio.
    public List<PlayerDTO> getPlayerBestAverage() {
        if (playerRepository == null) {
            throw new NoSuchElementException("No existe ningún jugador");
        }

        Optional<Player> playerWorseAverage = playerRepository.findAll().stream()
                .max(Comparator.comparingDouble(Player::calculateWinningAverage));

        if (playerWorseAverage.isPresent()) {
            double bestAverage = playerWorseAverage.get().calculateWinningAverage();
            List<Player> sameAverage = playerRepository.findAll().stream()
                    .filter(player -> player.calculateWinningAverage() == bestAverage)
                    .toList();
            return sameAverage.stream().map(this::toDTO).toList();
        }
        return null;
    }
}
