package com.turnos.repository;

import com.turnos.model.Paciente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {

    @Modifying
    @Query(value= "delete  from  paciente  where dni=:dni", nativeQuery = true)
    void eliminar(@Param("dni")Integer dni);

}
