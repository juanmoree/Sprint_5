package Sprint5.T2.n1.JuegoDeDados.Services;

import Sprint5.T2.n1.JuegoDeDados.Model.Game;
import Sprint5.T2.n1.JuegoDeDados.Model.Player;
import Sprint5.T2.n1.JuegoDeDados.Repository.GameRepository;
import Sprint5.T2.n1.JuegoDeDados.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void newGameByIdPlayer(PlayerRepository playerRepository, Long id) {
        Optional<Player> existingPlayer = playerRepository.findById(id);
        if (existingPlayer.isPresent()){
            byte dice1 = (byte) (Math.random() * 6 + 1);
            byte dice2 = (byte) (Math.random() * 6 + 1);
            Game game = new Game(existingPlayer.get(), dice1, dice2);

            existingPlayer.get().getGames().add(game);
            gameRepository.save(game);
        }
    }
}
