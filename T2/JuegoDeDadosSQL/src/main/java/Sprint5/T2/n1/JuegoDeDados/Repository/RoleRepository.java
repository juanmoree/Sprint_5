package Sprint5.T2.n1.JuegoDeDados.Repository;

import Sprint5.T2.n1.JuegoDeDados.Model.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
