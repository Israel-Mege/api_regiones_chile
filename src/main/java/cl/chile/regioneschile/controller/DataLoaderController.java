package cl.chile.regioneschile.controller;

import cl.chile.regioneschile.service.DataLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DataLoaderController {
    @Autowired
    private DataLoaderService dataLoaderService;

    @GetMapping("/api/load-data")
    public String loadData() {
        try {
            dataLoaderService.loadData();
            return "Datos cargados exitosamente";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al cargar los datos: " + e.getMessage();
        }
    }
}

