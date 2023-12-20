package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO;

import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

public class Sucursal {
    @Id
    @GeneratedValue
    private int pk_sucursalId;
    private String nombreSucursal;
    private String paisSucursal;

    public int getPk_sucursalId() {
        return pk_sucursalId;
    }

    public void setPk_sucursalId(int pk_sucursalId) {
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

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
}
