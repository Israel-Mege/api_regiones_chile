package cl.chile.regioneschile.service;

import cl.chile.regioneschile.model.Comuna;
import cl.chile.regioneschile.repository.ComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> getAllComunas() {
        return comunaRepository.findAll();
    }

    public Comuna saveRegion(Comuna comuna) {
        return comunaRepository.save(comuna);
    }
}
