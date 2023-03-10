package com.sping3.otro.curso.models.service;

import com.sping3.otro.curso.models.entity.Ciudad;
import com.sping3.otro.curso.models.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CiudadServiceImplement implements CiudadService{
    @Autowired
    private CiudadRepository ciudadRepository;
    @Override
    public List<Ciudad> listaCiudades() {
        return ciudadRepository.findAll();
    }

}
