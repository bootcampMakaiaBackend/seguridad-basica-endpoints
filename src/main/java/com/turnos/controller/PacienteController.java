package com.turnos.controller;

import com.turnos.model.Paciente;
import com.turnos.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/pacientes")
    public List<Paciente> listar(){
        return this.pacienteService.listar();
    }

    @PostMapping("/paciente")
    public void agregar(@RequestBody Paciente paciente){
        this.pacienteService.agregar(paciente);
    }

    @DeleteMapping("/paciente/{dni}")
    public void eliminar(@PathVariable("dni") Integer dni) {
        try{
            this.pacienteService.eliminar(dni);
        }catch (RuntimeException e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}