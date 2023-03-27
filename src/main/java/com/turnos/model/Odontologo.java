package com.turnos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "odontologo")
public class Odontologo {
    @Column(name = "apellido", length = 200, nullable = false)
    private String apellido;
    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;
    @Id
    @Column(name = "matricula")
    private Integer matricula;

    public Odontologo() {
    }

    public Odontologo(String apellido, String nombre, Integer matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
