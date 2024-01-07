package Sprint5.T2.n1.JuegoDeDados.Repository;

import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
}
