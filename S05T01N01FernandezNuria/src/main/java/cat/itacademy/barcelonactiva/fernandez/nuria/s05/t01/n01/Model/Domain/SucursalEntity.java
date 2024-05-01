package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.Domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Sucursal")
public class SucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_SucursalID;
    @Column(name = "Nombre")
    private String nomSucursal;
    @Column(name = "Pais")
    private String paisSucursal;
    public SucursalEntity(String nomSucursal, String paisSucursal){
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }
    public SucursalEntity(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SucursalEntity that = (SucursalEntity) o;
        return Objects.equals(pk_SucursalID, that.pk_SucursalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk_SucursalID);
    }

    public int getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(int pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
}

