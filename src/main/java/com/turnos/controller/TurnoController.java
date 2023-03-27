package com.turnos.controller;

import com.turnos.model.Turno;
import com.turnos.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class TurnoController {

    private TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PutMapping("/odontologo/{matricula}/paciente/{dni}/fecha/{fechaTurno}/asignar")
    public Turno agendar(@PathVariable ("matricula")Integer matricula,
                                        @PathVariable ("dni")Integer dni,
                                        @PathVariable ("fechaTurno")String fecha){
       return turnoService.asignarTurno(matricula, dni, fecha);
    }
}
