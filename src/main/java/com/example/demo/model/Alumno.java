package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String rut;
    private String nombre;
    private String direccion;
    @JsonManagedReference
    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<Materia> materiaList;

}
