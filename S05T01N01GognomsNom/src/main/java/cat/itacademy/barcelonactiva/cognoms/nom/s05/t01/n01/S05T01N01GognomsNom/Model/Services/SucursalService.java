package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    // Permite que el servicio interactúe con la capa de acceso a datos.
    private final SucursalRepository sucursalRepository;

    @Autowired
    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public SucursalDTO toDTO(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO(sucursal.getPk_sucursalId(), sucursal.getNombreSucursal(), sucursal.getPaisSucursal());
        dto.setTipoSucursal(sucursal.getPaisSucursal());
        return dto;
    }

    public Sucursal toEntity(SucursalDTO dto) {
        return new Sucursal(dto.getPk_sucursalId(), dto.getNombreSucursal(), dto.getPaisSucursal());
    }

    public void save(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    public List<Sucursal> getAllSucursales() {
        return sucursalRepository.findAll();
    }

    public Sucursal getSucursalById(Long id) {
        if (!sucursalRepository.existsById(id)) throw new RuntimeException("No existe la sucursal con id: " + id);
        else {
            Sucursal sucursal = sucursalRepository.findById(id).get();
            return sucursal;
        }
    }

    public void delete(Long id) {
        if (!sucursalRepository.existsById(id)) throw new RuntimeException("No existe la sucursal con id: " + id);
        else {
            sucursalRepository.deleteById(id);
        }
    }
}
