package com.base.JavaBase.repository;

import com.base.JavaBase.entity.Medico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query(value = " select * from medicos" +
            " where especialidade in :especialidades ", nativeQuery = true)
    List<Medico> findAllMedicosByEspecialidade(@Param("especialidades") List<String> especialidades);

    @Query(value = "select * from medicos" +
            " where codigo_hospital = :codigo " +
            " and especialidade = :especialidade"
           , nativeQuery = true)
    List<Medico> findAllMedicosByCodHospitalAndEspecialidade(@Param("codigo") Long codigo, @Param("especialidade") String especialidade);
}
