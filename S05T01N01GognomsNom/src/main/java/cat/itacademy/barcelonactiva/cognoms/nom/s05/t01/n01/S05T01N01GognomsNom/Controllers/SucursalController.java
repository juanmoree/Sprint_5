package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Repository.SucursalRepository;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


// Controller en lugar de RestController para poder usar Thymeleaf
@Controller
@RequestMapping("/sucursales")
public class SucursalController {
    @Autowired
    SucursalService sucursalService;
    @Autowired
    SucursalRepository sucursalRepository;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Sucursal addOrUpdate(@RequestBody SucursalDTO sucursalDTO) {
        Sucursal sucursal = sucursalService.toEntity(sucursalDTO);
        sucursalService.save(sucursal);
        return sucursal;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Sucursal updateSucursal(@RequestBody SucursalDTO sucursalDTO) {
        Sucursal sucursal = sucursalService.toEntity(sucursalDTO);
        sucursalService.save(sucursal);
        return sucursal;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSucursal(@PathVariable long id) {
        sucursalService.delete(id);
    }

    @GetMapping("/getOne/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Sucursal getOneSucursal(@PathVariable long id) {
        return sucursalService.getSucursalById(id);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Sucursal> getAllSucursal() {
        return sucursalService.getAllSucursales();
    }


                                ///// Thymeleaf - HTML /////
    @GetMapping("/list")
    public String listSucursales(Model model) {
        List<Sucursal> sucursales = sucursalRepository.findAll();

        // Convierte las entidades a DTOs y agrega la lista de DTOs al modelo
        List<SucursalDTO> sucursalDTOs = sucursales.stream()
                .map(sucursalService::toDTO)
                .collect(Collectors.toList());
        model.addAttribute("sucursales", sucursalDTOs);

        return "list";
    }

    @GetMapping("/form")
    public String showSucursalForm(Model model) {
        model.addAttribute("sucursal", new Sucursal());
        return "form";
    }

    @PostMapping("/save")
    public String saveSucursal(@ModelAttribute SucursalDTO sucursalDTO) {
        Sucursal sucursal = sucursalService.toEntity(sucursalDTO);
        sucursalService.save(sucursal);
        return "redirect:/sucursales/list";
    }

    @GetMapping("/edit/{id}")
    public String editSucursal(@PathVariable long id, Model model) {
        Sucursal sucursal = sucursalService.getSucursalById(id);
        model.addAttribute("sucursal", sucursal);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal1(@PathVariable long id) {
        sucursalService.delete(id);
        return "redirect:/sucursales/list";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}