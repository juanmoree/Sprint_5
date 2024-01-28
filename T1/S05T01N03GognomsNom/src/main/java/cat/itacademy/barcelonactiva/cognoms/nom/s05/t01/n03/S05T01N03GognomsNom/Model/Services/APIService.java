package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03GognomsNom.Model.Services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.S05T01N03GognomsNom.Model.DTO.ResultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class APIService {

    @Value("${spring.external.service.base-url}")
    private String basepath;
    private final RestTemplate restTemplate;

    List<String> urls = List.of(
            "add",
            "update",
            "delete",
            "getOne/{id}",
            "getAll"
    );

    public List<ResultDTO> getAll() {
        ResultDTO[] response = restTemplate.getForObject(basepath + "/getAll", ResultDTO[].class);
        return Arrays.asList(response);
    }

    public void save(ResultDTO resultDTO) {
        restTemplate.postForObject(basepath + "/add", resultDTO, ResultDTO.class);
    }

    public void update(ResultDTO resultDTO) {
        restTemplate.put(basepath + "/update", resultDTO);
    }

    public void delete(Integer id) {
        restTemplate.delete(basepath + "/delete/" + id);
    }

    public ResultDTO getOne(Integer id) {
        return restTemplate.getForObject(basepath + "/getOne/" + id, ResultDTO.class);
    }
}
