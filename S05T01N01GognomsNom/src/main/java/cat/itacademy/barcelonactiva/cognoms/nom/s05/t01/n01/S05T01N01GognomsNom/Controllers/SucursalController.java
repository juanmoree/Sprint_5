package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    @Autowired
    SucursalService sucursalService;

    @PostMapping("/add")
    public SucursalDTO addSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = sucursalService.toEntity(sucursalDTO);
        sucursal = sucursalRepository.save(sucursal);
        return sucursalService.toDTO(sucursal);
    }

    @PutMapping("/update")
    public SucursalDTO updateSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = sucursalService.toEntity(sucursalDTO);
        sucursal = sucursalService.save(sucursal);
        return sucursalService.toDTO(sucursal);
    }

    @DeleteMapping("/delete")
    public void deleteSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = sucursalService.toEntity(sucursalDTO);
        sucursalRepository.delete(sucursal);
    }

    @GetMapping("/getOne")
    public SucursalDTO getOneSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = sucursalService.toEntity(sucursalDTO);
        sucursal = sucursalRepository.getOne(sucursal.getPk_sucursalId());
        return sucursalService.toDTO(sucursal);
    }

    @GetMapping("/getAll")
    public List<SucursalDTO> getAllSucursal() {
        List<Sucursal> sucursales = sucursalRepository.findAll();
        List<SucursalDTO> sucursalesDTO = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {
            sucursalesDTO.add(sucursalService.toDTO(sucursal));
        }
        return sucursalesDTO;
    }

}

