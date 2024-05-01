
package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.Service;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.Domain.FlorEntity;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.Repository.FlorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlorService {
    @Autowired
    FlorRepository florRepository;

    public FlorDTO crear(FlorDTO florDTO){
        //guarda flotDTO en forma de Entity(porque lo convierte) en la bbdd. Y de ahí lo pasa de Entity a DTO
        return FlorDTO.convertirDesdeFlorEntity(florRepository.save(FlorDTO.convertirParaFlorEntity(florDTO)));
    }
    public FlorDTO actualizar(int id, FlorDTO florDTO){
        Optional<FlorEntity> optionalFlorEntity = florRepository.findById(id);
        FlorDTO florActualizada = null;

        if(optionalFlorEntity.isPresent()){
            FlorEntity florEntity = optionalFlorEntity.get();
            florEntity.setNomFlor(florDTO.getNomFlor());
            florEntity.setPaisFlor(florDTO.getPaisFlor());
            florRepository.save(florEntity);
            florActualizada = FlorDTO.convertirDesdeFlorEntity(florEntity);
        } else {
            throw new EntityNotFoundException("No se encuentra ninguna sucursal con el ID " + id);
        }
        return florActualizada;
    }
    public String borrar(int id){
        Optional <FlorEntity> florEntity = florRepository.findById(id);

        if(florEntity.isPresent()) {
            florRepository.deleteById(id);
            return "Se ha borrado la flor con ID " + id;
        }else{
            throw new EntityNotFoundException("No se ha encontrado el elemento con el ID " + id);
        }

    }
    public List<FlorDTO> findAll (){
        List<FlorEntity> listaFloresEntity = florRepository.findAll();

        return listaFloresEntity.stream().map(FlorDTO::convertirDesdeFlorEntity).collect(Collectors.toList());
    }
    public FlorDTO findById(int id){
        Optional <FlorEntity> florEntity = florRepository.findById(id);

        if(florEntity.isPresent()){
            return FlorDTO.convertirDesdeFlorEntity(florEntity.get());
        } else {
            throw new EntityNotFoundException("No se ha encontrado el elemento con el ID " + id);
        }
    }

}
