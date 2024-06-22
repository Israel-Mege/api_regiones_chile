package cl.chile.regioneschile.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

}
