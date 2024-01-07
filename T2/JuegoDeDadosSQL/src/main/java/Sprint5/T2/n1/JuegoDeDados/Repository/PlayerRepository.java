package Sprint5.T2.n1.JuegoDeDados.Repository;

import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findPlayerByName(String name);
}
