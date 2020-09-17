package com.example.demo.service.impl;

import com.example.demo.model.Alumno;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.service.jpa.AlumnoService;
import com.example.demo.utils.LogUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private LogUtility logUtility;

    @Override
    public Alumno findByRut(String rut) {
        logUtility.showLog("BUSCANDO POR RUT");
        return alumnoRepository.findByRut(rut);
    }

    @Override
    public void save(Alumno alumno) {
        logUtility.showLog("GUARDANDO");
        alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> findAll() {
        logUtility.showLog("BUSCANDO TODOS");
        return alumnoRepository.findAll();
    }
}
