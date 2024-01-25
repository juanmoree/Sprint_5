package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.Domain;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.DTO.FlowerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flor")
public class FlowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFlor")
    private int flowerId;
    private String flowerName;
    private String flowerCountry;

    public FlowerEntity(FlowerDTO flowerDTO) {
        this.flowerId = flowerDTO.getFlowerId();
        this.flowerName = flowerDTO.getFlowerName();
        this.flowerCountry = flowerDTO.getFlowerCountry();
    }
}
