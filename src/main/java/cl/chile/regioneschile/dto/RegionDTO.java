package cl.chile.regioneschile.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collector;

@Setter
@Getter
public class RegionDTO {

    private Long id;
    private String nombre;
    private String region_iso_3166_2;
    private String capital_regional;

    public RegionDTO() {
    }

    public RegionDTO(Long id, String nombre,String region_iso_3166_2, String capital_regional) {
        this.id = id;
        this.nombre = nombre;
        this.region_iso_3166_2 = region_iso_3166_2;
        this.capital_regional = capital_regional;
    }

}
