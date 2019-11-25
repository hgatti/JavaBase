package com.base.JavaBase.repository;

import com.base.JavaBase.entity.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {


    @Query(value = " select * from paciente" +
            " where (year(now()) - year(dat_nasc)) >= :idade ", nativeQuery = true)
    List<Paciente> findAllIdadeMaiorQue(@Param("idade") int idade);

    @Query(value = " select * from paciente" +
            " where (year(now()) - year(dat_nasc)) <= :idade ", nativeQuery = true)
    List<Paciente> findAllIdadeMenorQue(@Param("idade") int idade);
}
