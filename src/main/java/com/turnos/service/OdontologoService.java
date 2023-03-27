package com.turnos.service;

import com.turnos.model.Odontologo;
import com.turnos.repository.OdontologoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    private OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public List<Odontologo> listar(){
        return (List<Odontologo>) odontologoRepository.findAll();
    }

    public void agregar(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }

    public void modificar(Odontologo odontologo){ odontologoRepository.save(odontologo); }

    public void eliminar(Integer matricula){
        if (matricula <= 0){
            throw new RuntimeException("La matricula no puede ser menor o igual a cero");
        }
        try{
            odontologoRepository.deleteById(matricula);
        }catch(Exception e){
            throw new RuntimeException("El odontologo no se pudo eliminar");
        }
    }
}
