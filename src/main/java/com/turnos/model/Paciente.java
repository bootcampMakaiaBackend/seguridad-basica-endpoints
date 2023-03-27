package com.turnos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;
    @Column(name = "apellido", length = 200, nullable = false)
    private String apellido;
    @Column(name = "domicilio", length = 200, nullable = false)
    private String domicilio;
    @Id
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "fechaDeAlta")
    private LocalDate fechaDeAlta;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Paciente(String nombre, String apellido, String domicilio, Integer dni, LocalDate fechaDeAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaDeAlta = fechaDeAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public Integer getDNI() {
        return dni;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", dni=" + dni +
                ", fechaDeAlta=" + fechaDeAlta +
                '}';
    }

}
