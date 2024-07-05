package cl.chile.regioneschile.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComunaDTO {
    private Long id;
    private String nombre;
    private String codigo;

    public ComunaDTO() {
    }

    public ComunaDTO(Long id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
    }

}
