package com.turnos.repository;

import com.turnos.model.Turno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository  extends CrudRepository<Turno, Integer> {


}
