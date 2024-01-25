package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.Services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.DTO.FlowerDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.Domain.FlowerEntity;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.Repository.FlowerRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FlowerService {

    @Autowired
    private final FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public FlowerEntity toEntity(FlowerDTO flowerDTO) {
        return new FlowerEntity(flowerDTO);
    }

    public FlowerDTO toDTO(FlowerEntity flowerEntity) {
        return new FlowerDTO(flowerEntity);
    }

    public FlowerEntity addFlower(FlowerDTO flowerDTO) {
        FlowerEntity flower = toEntity(flowerDTO);
        if (flowerRepository.findByFlowerName(flowerDTO.getFlowerName()).isPresent()) {
            throw new EntityExistsException("Ya existe una flor con ese nombre");
        }
        flowerRepository.save(flower);
        return flower;
    }

    public FlowerEntity updateFlower(FlowerDTO flowerDTO) {

        Optional<FlowerEntity> flowerOptional = flowerRepository.findById(flowerDTO.getFlowerId());

        if (!flowerOptional.isPresent()) {
            throw new EntityNotFoundException("No se ha encontrado ninguna flor con ese ID");
        }

        FlowerEntity flower = flowerOptional.get();
        boolean sameName = flower.getFlowerName().equals(flowerDTO.getFlowerName());
        boolean sameCountry = flower.getFlowerCountry().equals(flowerDTO.getFlowerCountry());

        if (sameName && sameCountry) {
            throw new EntityExistsException("La flor " + flowerDTO.getFlowerName() + " ya tiene esos datos");
        } else {
            if (sameName) {
                flower.setFlowerCountry(flowerDTO.getFlowerCountry());
            } else {
                flower.setFlowerName(flowerDTO.getFlowerName());
            }
        }
        return flowerRepository.save(flower);
    }


    public void deleteById(Integer id) {

        Optional<FlowerEntity> flower = flowerRepository.findById(id);

        if (!flower.isPresent()) {
            throw new EntityNotFoundException("No se ha encontrado ninguna flor con ese ID");
        }

        flowerRepository.deleteById(id);
    }

    public FlowerDTO getById(Integer id) {

        Optional<FlowerEntity> flowerOptional = flowerRepository.findById(id);

        if (!flowerOptional.isPresent()) {
            throw new EntityNotFoundException("No se ha encontrado ninguna flor con ese ID");
        }

        FlowerEntity flower = flowerOptional.get();
        return toDTO(flower);
    }


    public List<FlowerDTO> getAllFlowers() {
        if (flowerRepository.findAll().isEmpty()) {
            throw new NoSuchElementException();
        }

        return flowerRepository.findAll().stream().map(this::toDTO).toList();
    }


}
