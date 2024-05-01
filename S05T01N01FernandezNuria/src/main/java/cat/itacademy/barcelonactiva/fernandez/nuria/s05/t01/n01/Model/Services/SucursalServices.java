package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.Services;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.DTO.DtoSucursal;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.Domain.SucursalEntity;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.Repository.SucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalServices {

    @Autowired
    SucursalRepository sucursalRepository;

    public DtoSucursal crear(DtoSucursal sucursalDTO){

       return DtoSucursal.convertirDesdeSucursalEntity(sucursalRepository.save(DtoSucursal.convertirParaSucursalEntity(sucursalDTO)));

        //Se cogen los datos desde la vista en forma de DTO y se convierten a SucursalEntity para que pueda almacenar los
        //datos en la base de datos. Con .save devuelve un dato SucursalEntity y lo convertimos en dato DTO para que lo
        //muestre en la vista desde el Controller
    }
    public DtoSucursal actualizar(int id, DtoSucursal sucursalDTO){//coge info de la vista como DTO y lo tiene que pasar a Entity para actualizar la bbdd
        Optional<SucursalEntity>sucursalEntityOptional = sucursalRepository.findById(id);
        DtoSucursal sucursalActualizada = null;

        if(sucursalEntityOptional.isPresent()) {
            SucursalEntity sucursal = sucursalEntityOptional.get();
            sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
            sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
            sucursalRepository.save(sucursal);
            sucursalActualizada = DtoSucursal.convertirDesdeSucursalEntity(sucursal);
        } else{
            throw new EntityNotFoundException("No se encuentra ninguna sucursal con el ID " + id);
        }
        return sucursalActualizada;
    }
    public String borrar(int id){
        Optional<SucursalEntity> sucursal = sucursalRepository.findById(id);
        if(sucursal.isPresent()){
            sucursalRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("No se ha podido borrar la sucursal con ID " + id);
        }
        return "Se ha borrado el producto con el id " + id;
    }
    public List<DtoSucursal> findAll(){//Tengo que pasar de Entity a DTO
        List<SucursalEntity> listaSucursales =  sucursalRepository.findAll();

        return listaSucursales.stream().map(DtoSucursal::convertirDesdeSucursalEntity).collect(Collectors.toList());
        //La lambda es el resumen de:
        /*List<DtoSucursal> listaSucursalesDTO = new ArrayList<>();
        for(SucursalEntity sucursal : listaSucursales){
            listaSucursalesDTO.add(DtoSucursal.convertirDesdeSucursalEntity(sucursal));
        }

        return listaSucursalesDTO;*/


    }
    public DtoSucursal findById(int id){
        Optional <SucursalEntity> sucursal = sucursalRepository.findById(id);
        if(sucursal.isPresent()) {
            return DtoSucursal.convertirDesdeSucursalEntity(sucursal.get());
        } else {
            throw new EntityNotFoundException("No se encuentra ninguna sucursal con el ID " + id);
        }
    }



}
