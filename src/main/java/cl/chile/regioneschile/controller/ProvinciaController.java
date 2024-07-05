package cl.chile.regioneschile.controller;

import cl.chile.regioneschile.dto.ProvinciaDTO;
import cl.chile.regioneschile.exception.ResourceNotFoundException;
import cl.chile.regioneschile.model.Provincia;
import cl.chile.regioneschile.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @GetMapping
    public List<ProvinciaDTO> getAllProvincias() {
        List<Provincia> provincias = provinciaRepository.findAll();
        return provincias.stream()
                .map(provincia -> new ProvinciaDTO(provincia.getId(), provincia.getNombre(), provincia.getCodigo(), provincia.getCapital_provincial()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProvinciaDTO getProvinciaById(@PathVariable Long id) {
        Provincia provincia = provinciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Provincia not found"));
        return new ProvinciaDTO(provincia.getId(), provincia.getNombre(), provincia.getCodigo(), provincia.getCapital_provincial());
    }


}
