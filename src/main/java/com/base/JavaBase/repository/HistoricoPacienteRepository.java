package com.base.JavaBase.repository;

import com.base.JavaBase.entity.HistoricoPaciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoPacienteRepository extends JpaRepository<HistoricoPaciente, Long> {

    @Query(value = "select * from historico_paciente " +
            " where cod_proced_diag = :codigo ", nativeQuery = true)
    List<HistoricoPaciente> findAllByDiagnosticoCode(@Param("codigo") Long codigo);

    @Query(value = "select * from historico_paciente hp1 " +
            " where hp1.cod_proced_diag = :codigo " +
            " and exists (select count(*)  from historico_paciente hp2 " +
            "            where hp2.cod_proced_diag = :codigo " +
            "            and hp1.codigo_sus_paciente = hp2.codigo_sus_paciente " +
            "            HAVING Count(*) > 1) "
            , nativeQuery = true)
    List<HistoricoPaciente> findAllTwice(@Param("codigo") Long codigo);
}
