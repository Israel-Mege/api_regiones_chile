package cl.chile.regioneschile.controller;

import cl.chile.regioneschile.dto.RegionDTO;
import cl.chile.regioneschile.exception.ResourceNotFoundException;
import cl.chile.regioneschile.model.Region;
import cl.chile.regioneschile.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/regiones")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public List<RegionDTO> getAllRegiones() {
        List<Region> regiones = regionRepository.findAll();
        return regiones.stream()
                .map(region -> new RegionDTO(region.getId(), region.getNombre(), region.getRegion_iso_3166_2(), region.getCapital_regional()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RegionDTO getRegionById(@PathVariable Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + id));
        return new RegionDTO(region.getId(), region.getNombre(), region.getRegion_iso_3166_2(), region.getCapital_regional());
    }

}
