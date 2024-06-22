package cl.chile.regioneschile.service;

import cl.chile.regioneschile.model.Region;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.chile.regioneschile.repository.RegionRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DataLoaderService {
    @Autowired
    private RegionRepository regionRepository;

    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/static/territoriochile.json");
        try {
            List<Region> regiones = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Region.class));
            regionRepository.saveAll(regiones);
        } catch (IOException e) {
            throw new IOException("Error al cargar los datos: " + e.getMessage());
        }
    }
}

