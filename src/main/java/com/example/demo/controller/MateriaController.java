package com.example.demo.controller;

import com.example.demo.model.Materia;
import com.example.demo.service.jpa.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @PostMapping
    public void create(@RequestBody Materia materia) {
        materiaService.save(materia);
    }
}
