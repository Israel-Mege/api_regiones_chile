package cl.chile.regioneschile.service;

import cl.chile.regioneschile.model.Comuna;
import cl.chile.regioneschile.model.Provincia;
import cl.chile.regioneschile.model.Region;
import cl.chile.regioneschile.repository.ComunaRepository;
import cl.chile.regioneschile.repository.ProvinciaRepository;
import cl.chile.regioneschile.repository.RegionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DataLoaderService {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private ComunaRepository comunaRepository;

    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/static/territoriochile.json");
        try {
            List<Region> regiones = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Region.class));

            for (Region region : regiones) {
                regionRepository.save(region);  // Guarda la región primero para obtener su ID

                for (Provincia provincia : region.getProvincias()) {
                    provincia.setRegion(region);  // Establece la relación con la región
                    provinciaRepository.save(provincia);  // Guarda la provincia para obtener su ID

                    for (Comuna comuna : provincia.getComunas()) {
                        comuna.setProvincia(provincia);  // Establece la relación con la provincia
                        comunaRepository.save(comuna);  // Guarda la comuna
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al cargar los datos: " + e.getMessage());
        }
    }
}
