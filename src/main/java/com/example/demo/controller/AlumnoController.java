package com.example.demo.controller;

import com.example.demo.model.Alumno;
import com.example.demo.service.jpa.AlumnoService;
import com.example.demo.service.jpa.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {

    private AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Alumno alumno) {
        alumnoService.save(alumno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Alumno> todos() {
        return alumnoService.findAll();
    }

    @GetMapping("/{rut}")
    @ResponseStatus(HttpStatus.OK)
    public Alumno findByRut(String rut) {
        return alumnoService.findByRut(rut);
    }

}
