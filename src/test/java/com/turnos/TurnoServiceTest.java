package com.turnos;

import com.turnos.model.Odontologo;
import com.turnos.model.Paciente;
import com.turnos.model.Turno;
import com.turnos.repository.OdontologoRepository;
import com.turnos.repository.PacienteRepository;
import com.turnos.repository.TurnoRepository;
import com.turnos.service.TurnoService;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TurnoServiceTest {

    TurnoRepository turnoRepository;
    OdontologoRepository odontologoRepository;
    PacienteRepository pacienteRepository;
    TurnoService turnoService;

    @Before
    public void setUp(){
        this.turnoRepository = mock(TurnoRepository.class);
        this.odontologoRepository = mock(OdontologoRepository.class);
        this.pacienteRepository = mock(PacienteRepository.class);
        this.turnoService = new TurnoService(turnoRepository, odontologoRepository, pacienteRepository);
    }

    @Test
    public void probarSumaConPrimerNumeroNegativo(){
        //Arrange
        Integer numero1 = -1;
        Integer numero2 = 2;
        //act
        Integer suma = this.turnoService.sumar(numero1, numero2);
        //assert
        assertTrue(suma == 0);
    }

    @Test
    public void probarSumaConSegundoNumeroNegativo(){
        //Arrange
        Integer numero1 = 1;
        Integer numero2 = -2;
        //act
        Integer suma = this.turnoService.sumar(numero1, numero2);
        //assert
        assertTrue(suma == 0);
    }

    @Test
    public void probarSumaConDosNumerosNegativos(){
        //Arrange
        Integer numero1 = -1;
        Integer numero2 = -2;
        //act
        Integer suma = this.turnoService.sumar(numero1, numero2);
        //assert
        assertTrue(suma == 0);
    }

    @Test
    public void sumaexitosa(){
        //Arrange
        Integer numero1 = 1;
        Integer numero2 = 2;
        //act
        Integer suma = this.turnoService.sumar(numero1, numero2);
        //assert
        assertTrue(suma == 3);
    }

    @Test(expected = RuntimeException.class)
    public void asignarTurnoConFechaNula(){
        //Arrange
        Integer matricula = 12;
        Integer dni = 12333;
        String fecha = null;
        //act
        Turno turno = this.turnoService.asignarTurno(matricula, dni, fecha);
    }

    @Test
    public void agendarCitaCuandoOdontologoNoExisteYPacienteExiste(){
        //Arrange
        Integer matricula = 12;
        Integer dni = 12333;
        String fecha = "2013-12-10";
        Paciente paciente = new Paciente("juan", "cadavid");
        when(pacienteRepository.findById(any())).thenReturn(Optional.of(paciente));
        when(odontologoRepository.findById(any())).thenReturn(Optional.empty());
        //act
        Turno turno = this.turnoService.asignarTurno(matricula, dni, fecha);
        //assert
        assertTrue(turno.getOdontologo() == null);
        assertTrue(turno.getFfechaTurno() == null);
    }

    @Test
    public void agendarCitaCuandoOdontologoExisteYPacienteExisteNo(){

    }

    @Test
    public void agendarCitaFormatoFechaIncorrecto(){
        //TODO: Corregir para que funcione cuando la fecha esta en formato incorrecto
        //TODO:puede ser con un try catch , o pueden validarlo con una expresion regular/

        //Arrange
        Integer matricula = 12;
        Integer dni = 12333;
        String fecha = "12-10-1023";
        Paciente paciente = new Paciente("juan", "cadavid");
        Odontologo odontologo = new Odontologo("Tomas", "sanchez", 1234);
        when(pacienteRepository.findById(any())).thenReturn(Optional.of(paciente));
        when(odontologoRepository.findById(any())).thenReturn(Optional.of(odontologo));
        //act
        Turno turno = this.turnoService.asignarTurno(matricula, dni, fecha);
        //assert
        assertTrue(turno.getOdontologo() == null);
        assertTrue(turno.getFfechaTurno() == null);
    }

    @Test
    public void agendarCita(){
        //Arrange
        Integer matricula = 12;
        Integer dni = 12333;
        String fecha = "2023-12-10 10:22";
        Paciente paciente = new Paciente("juan", "cadavid");
        Odontologo odontologo = new Odontologo("Tomas", "sanchez", 1234);
        when(pacienteRepository.findById(any())).thenReturn(Optional.of(paciente));
        when(odontologoRepository.findById(any())).thenReturn(Optional.of(odontologo));
        //act
        Turno turno = this.turnoService.asignarTurno(matricula, dni, fecha);
        //assert
        verify(turnoRepository, times(1)).save(any());
        assertTrue(turno.getOdontologo().getNombre().equals("sanchez"));
        assertTrue(turno.getFfechaTurno() != null);
    }



}
