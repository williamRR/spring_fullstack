package com.example.demo.service.impl;

import com.example.demo.model.Materia;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.service.jpa.MateriaService;
import com.example.demo.utils.LogUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private LogUtility logUtility;

    @Override
    public void save(Materia materia) {
        logUtility.showLog("GUARDANDO MATERIA");
        materiaRepository.save(materia);
    }
}
