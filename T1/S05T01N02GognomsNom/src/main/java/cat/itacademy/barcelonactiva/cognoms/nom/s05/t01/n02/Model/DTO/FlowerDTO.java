package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.DTO;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.Domain.FlowerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerDTO {
    private int flowerId;
    private String flowerName;
    private String flowerCountry;
    private String flowerType;

    private static final List<String> countriesUE = Arrays.asList("Austria", "Belgica",
            "Bulgaria", "Croacia", "Chipre", "Republica Checa", "Dinamarca", "Estonia",
            "Finlandia", "Francia", "Alemania", "Grecia", "Hungria", "Irlanda", "Italia",
            "Letonia", "Lituania", "Luxemburgo", "Malta", "Paises Bajos", "Polonia",
            "Portugal", "Rumania", "Eslovaquia", "Eslovenia", "Espana", "Suecia");

    public FlowerDTO(FlowerEntity flower){
        this.flowerId = flower.getFlowerId();
        this.flowerName = flower.getFlowerName();
        this.flowerCountry = flower.getFlowerCountry();
        this.flowerType = countriesUE.contains(flowerCountry) ? "UE" : "Fuera UE";
    }
}
