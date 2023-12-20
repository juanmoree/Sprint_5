package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {
    @Autowired
    SucursalRepository sucursalRepository;

    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }
    public SucursalDTO toDTO(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO();
        dto.setPk_sucursalId(sucursal.getPk_sucursalId());
        dto.setNombreSucursal(sucursal.getNombreSucursal());
        dto.setPaisSucursal(sucursal.getPaisSucursal());
        return dto;
    }

    public Sucursal toEntity(SucursalDTO dto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_sucursalId(dto.getPk_sucursalId());
        sucursal.setNombreSucursal(dto.getNombreSucursal());
        sucursal.setPaisSucursal(dto.getPaisSucursal());
        return sucursal;
    }
}
