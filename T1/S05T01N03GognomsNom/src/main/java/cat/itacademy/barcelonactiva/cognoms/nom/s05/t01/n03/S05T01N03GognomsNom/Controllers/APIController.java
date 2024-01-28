package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03GognomsNom.Controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03GognomsNom.Model.DTO.ResultDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03GognomsNom.Model.Services.APIService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/flor")
@RequiredArgsConstructor
public class APIController {

    @Autowired
    private final APIService apiService;

    @PostMapping("/clientFlorsAdd")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody ResultDTO resultDTO){
        apiService.save(resultDTO);
    }

    @PutMapping("/clientFlorsUpdate")
    public void update(@RequestBody ResultDTO resultDTO){
        apiService.update(resultDTO);
    }

    @DeleteMapping("/clientFlorsDelete/{id}")
    public void delete(@PathVariable Integer id){
        apiService.delete(id);
    }

    @GetMapping("/clientFlorsGetOne/{id}")
    public ResponseEntity<ResultDTO> getOne(@PathVariable Integer id) {
       return new ResponseEntity<>(apiService.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/clientFlorsAll")
    public ResponseEntity<List<ResultDTO>> getAll(){
        return new ResponseEntity<>(apiService.getAll(), HttpStatus.OK);
    }
}
