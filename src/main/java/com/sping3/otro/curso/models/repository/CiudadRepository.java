package com.sping3.otro.curso.models.repository;

import com.sping3.otro.curso.models.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad,Long> {
}
