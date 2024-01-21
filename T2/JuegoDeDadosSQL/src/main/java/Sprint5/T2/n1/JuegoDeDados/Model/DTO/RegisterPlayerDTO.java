package Sprint5.T2.n1.JuegoDeDados.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPlayerDTO {

    private String email;
    private String name;
    private String password;
    @JsonIgnore
    private Set<String> roles;
}
