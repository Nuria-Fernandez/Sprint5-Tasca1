package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.Domain;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name="Flores")
public class FlorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_FlorID;
    @Column(name="Nombre")
    private String nomFlor;
    @Column(name="País")
    private String paisFlor;

    public FlorEntity(String nomFlor, String paisFlor){
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
    }
    public FlorEntity(){

    }

    public int getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(int pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    @Override
    public String toString() {
        return "FlorEntity{" +
                "pk_FlorID=" + pk_FlorID +
                ", nomFlor='" + nomFlor + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlorEntity that = (FlorEntity) o;
        return pk_FlorID == that.pk_FlorID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk_FlorID);
    }
}
