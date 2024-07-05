package cl.chile.regioneschile.controller;

import cl.chile.regioneschile.dto.ComunaDTO;
import cl.chile.regioneschile.exception.ResourceNotFoundException;
import cl.chile.regioneschile.model.Comuna;
import cl.chile.regioneschile.repository.ComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comunas")
public class ComunaController {

    @Autowired
    private ComunaRepository comunaRepository;

    @GetMapping
    public List<ComunaDTO> getAllComunas() {
        List<Comuna> comunas = comunaRepository.findAll();
        return comunas.stream()
                .map(comuna -> new ComunaDTO(comuna.getId(), comuna.getNombre(), comuna.getCodigo()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ComunaDTO getComunaById(@PathVariable Long id) {
        Comuna comuna = comunaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comuna not found"));
        return new ComunaDTO(comuna.getId(), comuna.getNombre(), comuna.getCodigo());
    }


}
