package Sprint5.T2.n1.JuegoDeDados;

import Sprint5.T2.n1.JuegoDeDados.Model.ERole;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.Player;
import Sprint5.T2.n1.JuegoDeDados.Model.Entity.RoleEntity;
import Sprint5.T2.n1.JuegoDeDados.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class JuegoDeDadosApplication {
    public static void main(String[] args) {
        SpringApplication.run(JuegoDeDadosApplication.class, args);
    }
}
