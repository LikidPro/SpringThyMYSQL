package com.sping3.otro.curso.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ciudades")
public class Ciudad implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Cuidad;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCuidad() {
        return Cuidad;
    }

    public void setCuidad(String cuidad) {
        Cuidad = cuidad;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", Cuidad='" + Cuidad + '\'' +
                '}';
    }
}
