package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Controllers;


import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.DTO.DtoSucursal;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.Services.SucursalServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalServices sucursalServices;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sucursal", new DtoSucursal());
        return "add-sucursal";
    }

    @PostMapping("/add")
    public String addSucursal(@ModelAttribute("sucursal") DtoSucursal sucursalDTO) {
        sucursalServices.crear(sucursalDTO);
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        try {
            DtoSucursal sucursalDTO = sucursalServices.findById(id);
            model.addAttribute("sucursal", sucursalDTO);
        }catch(EntityNotFoundException d){
            d.getMessage();
        }
        return "update-sucursal";
    }

    @PostMapping("/update/{id}")
    public String updateSucursal(@PathVariable("id") int id, @ModelAttribute("sucursal") DtoSucursal sucursalDTO) {
        try {
            sucursalServices.actualizar(id, sucursalDTO);
        }catch (EntityNotFoundException e){
            e.getMessage();
        }
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") int id) {
        try {
            sucursalServices.borrar(id);
        }catch (EntityNotFoundException f){
            f.getMessage();
        }
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/getOne/{id}")
    public String getOneSucursal(@PathVariable("id") int id, Model model) {
        try {
            DtoSucursal sucursalDTO = sucursalServices.findById(id);
            model.addAttribute("sucursal", sucursalDTO);
        }catch (EntityNotFoundException g){
            model.addAttribute("error", "No se ha podido encontrar el ID " +id);
        }
        return "view-sucursal";
    }

    @GetMapping("/getAll")
    public String getAllSucursales(Model model) {
        model.addAttribute("sucursales", sucursalServices.findAll());
        return "list-sucursales";
    }
}
