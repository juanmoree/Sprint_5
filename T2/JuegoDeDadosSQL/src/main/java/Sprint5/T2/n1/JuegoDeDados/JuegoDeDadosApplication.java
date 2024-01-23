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

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	PlayerRepository playerRepository;

	@Bean
	CommandLineRunner init(){
		return args -> {

			Player player = Player.builder()
					.name("p1")
					.password(passwordEncoder.encode("123456"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();
			Player player2 = Player.builder()
					.name("p2")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.USER.name()))
							.build()))
					.build();
			Player player3 = Player.builder()
					.name("p3")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.INVITED.name()))
							.build()))
					.build();

			playerRepository.save(player);
			playerRepository.save(player2);
			playerRepository.save(player3);
		};
	}
}
