package cl.chile.regioneschile.controller;

import cl.chile.regioneschile.model.Comuna;
import cl.chile.regioneschile.repository.ComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunas")
public class ComunaController {

    @Autowired
    private ComunaRepository comunaRepository;

    @GetMapping
    public List<Comuna> getAllComunas() {
        return comunaRepository.findAll();
    }

    @PostMapping
    public Comuna createComuna(@RequestBody Comuna comuna) {
        return comunaRepository.save(comuna);
    }

}
