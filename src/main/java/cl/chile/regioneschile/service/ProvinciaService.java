package cl.chile.regioneschile.service;

import cl.chile.regioneschile.model.Region;
import cl.chile.regioneschile.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegiones() {
        return regionRepository.findAll();
    }

    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }

}
