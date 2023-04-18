package com.turnos.controller;

import com.turnos.model.Odontologo;
import com.turnos.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
public class OdontologoController {

    private OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PreAuthorize("hasRole('READ')")
    @GetMapping("/odontologos")
    public List<Odontologo> listar(){
        return this.odontologoService.listar();
    }

    @PostMapping("/odontologo")
    public void agregar(@RequestBody Odontologo odontologo){
        this.odontologoService.agregar(odontologo);
    }

    @PreAuthorize("hasRole('WRITE')")
    @DeleteMapping("/odontologo/{matricula}")
    public void eliminar(@PathVariable("matricula") Integer matricula) {
        try{
            this.odontologoService.eliminar(matricula);
        }catch (RuntimeException e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
