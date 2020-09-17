package com.example.demo.service.jpa;

import com.example.demo.model.Alumno;

import java.util.List;

public interface AlumnoService {
    Alumno findByRut(String rut);

    void save(Alumno alumno);

    List<Alumno> findAll();

}
