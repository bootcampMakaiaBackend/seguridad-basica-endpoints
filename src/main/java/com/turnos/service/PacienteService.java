package com.turnos.service;

import com.turnos.model.Paciente;
import com.turnos.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = (PacienteRepository) pacienteRepository;
    }

    public List<Paciente> listar(){
        return (List<Paciente>) pacienteRepository.findAll();
    }

    public void agregar(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public void modificar(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public void eliminar(Integer dni){
        if (dni <= 0){
            throw new RuntimeException("La dni no puede ser menor o igual a cero");
        }
        try{
            pacienteRepository.deleteById(dni);
        }catch(Exception e){
            throw new RuntimeException("El paciente no se pudo eliminar");
        }
    }
}
