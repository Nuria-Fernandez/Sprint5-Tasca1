package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.DTO;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.Domain.SucursalEntity;

import java.util.Arrays;
import java.util.List;

public class DtoSucursal {
    private int pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;
    private static List<String> paises = Arrays.asList("Bélgica", "Bulgaria", "República Checa", "Dinamarca", "Alemania", "Estonia", "Irlanda", "Grecia", "España",
            "Francia", "Croacia", "Italia", "Chipre", "Letonia", "Lituania", "Luxemburgo", "Hungría", "Malta",
            "Países Bajos", "Austria", "Polonia", "Portugal", "Rumanía", "Eslovenia", "Eslovaquia", "Finlandia", "Suecia");

    public DtoSucursal(){}
    public DtoSucursal(int pk_SucursalID, String nomSucursal, String paisSucursal, String tipusSucursal){
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        this.tipusSucursal = tipusSucursal;
        
    }
    //Tengo que convertir una sucursal en DTO porque ha recibido los datos del Controller para enviarlos a la Vista.
    // Por eso le paso el objeto SucursalEntity
    public static DtoSucursal convertirDesdeSucursalEntity(SucursalEntity sucursal){
        DtoSucursal sucursalDTO = new DtoSucursal();

        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());

        if(paises.contains(sucursal.getPaisSucursal())){
            sucursalDTO.setTipusSucursal("Pertenece a la UE");
        } else{
            sucursalDTO.setTipusSucursal("Fuera de la UE");
        }
        return sucursalDTO;
    }
    //Tengo que convertir un DTO en sucursalEntity para el envío de datos al Controller(Los datos llegan desde la interfaz del usuario)
    public static SucursalEntity convertirParaSucursalEntity(DtoSucursal sucursalDTO){
        SucursalEntity sucursal = new SucursalEntity();

        sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
        sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
        return sucursal;
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

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

    public List<String> getPaises() {
        return paises;
    }

    public void setPaises(List<String> paises) {
        this.paises = paises;
    }
}
