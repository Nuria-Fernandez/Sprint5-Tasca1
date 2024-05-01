package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.DTO;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.Domain.FlorEntity;

import java.util.Arrays;
import java.util.List;

public class FlorDTO {
    private int pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipoFlor;
    private static List<String> paises = Arrays.asList("Bélgica", "Bulgaria", "Chequia", "Dinamarca", "Alemania", "Estonia", "Irlanda", "Grecia", "España",
            "Francia", "Croacia", "Italia", "Chipre", "Letonia", "Lituania", "Luxemburgo", "Hungría", "Malta",
            "Países Bajos", "Austria", "Polonia", "Portugal", "Rumanía", "Eslovenia", "Eslovaquia", "Finlandia", "Suecia");
    public FlorDTO(){

    }
    public FlorDTO(int pk_FlorID, String nomFlor, String paisFlor, String tipoFlor){
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        this.tipoFlor = tipoFlor;
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

    public String getTipoFlor() {
        return tipoFlor;
    }

    public void setTipoFlor(String tipoFlor) {
        this.tipoFlor = tipoFlor;
    }

    public static List<String> getPaises() {
        return paises;
    }

    public static void setPaises(List<String> paises) {
        FlorDTO.paises = paises;
    }

    @Override
    public String toString() {
        return "FlorDTO{" +
                "pk_FlorID=" + pk_FlorID +
                ", nomFlor='" + nomFlor + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                ", tipoFlor='" + tipoFlor + '\'' +
                '}';
    }

    public static FlorDTO convertirDesdeFlorEntity(FlorEntity florEntity){
        FlorDTO florDTO = new FlorDTO();

        florDTO.setPk_FlorID(florEntity.getPk_FlorID());
        florDTO.setNomFlor(florEntity.getNomFlor());
        florDTO.setPaisFlor(florEntity.getPaisFlor());

        if (paises.contains(florEntity.getPaisFlor())) {
            florDTO.setTipoFlor("Pertenece a la UE");
        } else {
            florDTO.setTipoFlor("Está fuera de la UE");
        }
        return florDTO;
    }
    public static FlorEntity convertirParaFlorEntity(FlorDTO florDTO){
        FlorEntity florEntity = new FlorEntity();
        florEntity.setPk_FlorID(florDTO.getPk_FlorID());
        florEntity.setNomFlor(florDTO.getNomFlor());
        florEntity.setPaisFlor(florDTO.getPaisFlor());
        return florEntity;
    }

}
