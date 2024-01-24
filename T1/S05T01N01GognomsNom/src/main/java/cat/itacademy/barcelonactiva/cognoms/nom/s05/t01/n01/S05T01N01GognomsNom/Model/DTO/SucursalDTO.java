package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO {

    private Long pk_sucursalId;
    private String nombreSucursal;
    private String paisSucursal;
    private String tipoSucursal;

    public SucursalDTO() {
    }

    public SucursalDTO(Long id, String nombre, String pais) {
        this.pk_sucursalId = id;
        this.nombreSucursal = nombre;
        this.paisSucursal = pais;
        this.tipoSucursal = paisesUE.contains(pais) ? "UE" : "Fuera UE";
    }

    private static final List<String> paisesUE = Arrays.asList("Austria", "Belgica",
            "Bulgaria", "Croacia", "Chipre", "Republica Checa", "Dinamarca", "Estonia",
            "Finlandia", "Francia", "Alemania", "Grecia", "Hungria", "Irlanda", "Italia",
            "Letonia", "Lituania", "Luxemburgo", "Malta", "Paises Bajos", "Polonia",
            "Portugal", "Rumania", "Eslovaquia", "Eslovenia", "Espana", "Suecia");

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public long getPk_sucursalId() {
        return pk_sucursalId;
    }

    public void setPk_sucursalId(Long pk_sucursalId) {
        this.pk_sucursalId = pk_sucursalId;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setTipoSucursal(String paisSucursal) {
        this.tipoSucursal = paisesUE.contains(paisSucursal) ? "UE" : "Fuera UE";
    }

    public String getTipoSucursal() {
        return tipoSucursal;
    }

}
