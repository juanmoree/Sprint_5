package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.Repository;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.Domain.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlowerRepository extends JpaRepository<FlowerEntity, Integer> {
    Optional<FlowerEntity> findByFlowerName(String name);
}
