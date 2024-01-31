/*
package Sprint5.T2.n1.JuegoDeDados;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import Sprint5.T2.n1.JuegoDeDados.Model.DTO.PlayerDTO;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import Sprint5.T2.n1.JuegoDeDados.Repository.PlayerRepository;
import Sprint5.T2.n1.JuegoDeDados.Services.PlayerService;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceUnitTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void testAddPlayer() {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName("Test Player");

        when(playerRepository.findPlayerByName(anyString())).thenReturn(Optional.empty());

        playerService.addPlayer(playerDTO);

        verify(playerRepository, times(1)).save(any(Player.class));
    }
}
*/
