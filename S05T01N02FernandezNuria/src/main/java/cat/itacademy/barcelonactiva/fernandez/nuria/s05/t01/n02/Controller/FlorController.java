package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Controller;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.Domain.FlorEntity;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.Service.FlorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    private FlorService florService;
    @PostMapping("/add")
    ResponseEntity<FlorDTO> crear(@RequestBody FlorDTO florDTO){
        FlorDTO florDTO2 = florService.crear(florDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(florDTO2);
    }
    @PutMapping("update/{id}")
    ResponseEntity<FlorDTO> actualizar(@PathVariable int id, @RequestBody FlorDTO florDTO) {
        ResponseEntity<FlorDTO> responseEntity;
        FlorDTO florDTO2;
        try {
            florDTO2 = florService.actualizar(id, florDTO);
            responseEntity = ResponseEntity.ok(florDTO2);
        } catch (EntityNotFoundException e) {
            e.getMessage();
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }
    @DeleteMapping("delete/{id}")
    ResponseEntity <String> borrar(@PathVariable int id){
        ResponseEntity<String> responseEntity;

        try{
            String mensaje = florService.borrar(id);
            responseEntity = ResponseEntity.ok(mensaje);
        }catch (EntityNotFoundException f){
            f.getMessage();
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }
    @GetMapping("/getAll")
    ResponseEntity<List<FlorDTO>> getAll(){
        List<FlorDTO> listaFlores = florService.findAll();
        ResponseEntity<List<FlorDTO>> responseEntity;
        if(listaFlores.isEmpty()){
            responseEntity = ResponseEntity.noContent().build();
        }else{
            responseEntity = ResponseEntity.ok(listaFlores);
        }
        return responseEntity;
    }
    @GetMapping("/getOne/{id}")
    ResponseEntity<FlorDTO> getOne(@PathVariable int id){
        ResponseEntity<FlorDTO> responseEntity;
        FlorDTO florDTO;
        try{
            florDTO = florService.findById(id);
            responseEntity = ResponseEntity.ok(florDTO);
        }catch(EntityNotFoundException g){
            g.getMessage();
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }


}
