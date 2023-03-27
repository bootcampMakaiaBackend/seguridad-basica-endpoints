package com.turnos.repository;

import com.turnos.model.Odontologo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends CrudRepository<Odontologo, Integer> {

    @Modifying
    @Query(value= "delete  from  odontologo  where matricula=:matricula", nativeQuery = true)
    void eliminar(@Param("matricula")Integer matricula);

}
