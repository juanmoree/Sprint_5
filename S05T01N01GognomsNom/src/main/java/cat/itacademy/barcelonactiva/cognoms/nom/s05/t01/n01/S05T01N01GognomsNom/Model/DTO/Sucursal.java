package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_sucursal_id")
    private long pk_sucursalId;
    private String nombreSucursal;
    private String paisSucursal;

    public Sucursal() {
    }

    public Sucursal(long id, String nombre, String pais) {
        this.pk_sucursalId = id;
        this.nombreSucursal = nombre;
        this.paisSucursal = pais;
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

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
}
