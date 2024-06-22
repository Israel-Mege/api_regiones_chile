package cl.chile.regioneschile.controller;

import cl.chile.regioneschile.model.Provincia;
import cl.chile.regioneschile.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @GetMapping
    public List<Provincia> getAllProvincias() {
        return provinciaRepository.findAll();
    }

    @PostMapping
    public Provincia createProvincia(@RequestBody Provincia provincia) {
        return provinciaRepository.save(provincia);
    }


}
