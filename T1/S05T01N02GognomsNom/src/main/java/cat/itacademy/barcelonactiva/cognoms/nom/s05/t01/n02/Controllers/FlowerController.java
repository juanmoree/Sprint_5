package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.DTO.FlowerDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.Domain.FlowerEntity;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.Model.Services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlowerController {

    @Autowired
    private final FlowerService flowerService;

    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @PostMapping("/add")
    public FlowerEntity addFlower(@RequestBody FlowerDTO flowerDTO){
        return flowerService.addFlower(flowerDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<FlowerEntity> updateFlower(@RequestBody FlowerDTO flowerDTO){
        return ResponseEntity.ok(flowerService.updateFlower(flowerDTO));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteFlowerById(@PathVariable Integer id){
        flowerService.deleteById(id);
    }

    @GetMapping("getOne/{id}")
    @ResponseBody
    public FlowerDTO getFlowerById(@PathVariable Integer id){
        return flowerService.getById(id);
    }

    @GetMapping("/getAll")
    public List<FlowerDTO> getAllFlowers(){
        return flowerService.getAllFlowers();
    }
}
