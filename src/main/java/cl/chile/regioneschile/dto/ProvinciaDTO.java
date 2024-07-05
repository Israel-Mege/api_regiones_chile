package cl.chile.regioneschile.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProvinciaDTO {

    private Long id;
    private String nombre;
    private String codigo;
    private String capital_provincial;

    public ProvinciaDTO() {
    }

    public ProvinciaDTO(Long id, String nombre, String codigo, String capital_provincial) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.capital_provincial = capital_provincial;
    }


}
