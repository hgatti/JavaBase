package com.base.JavaBase.repository;

import com.base.JavaBase.entity.HistoricoFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoFamiliarRepository extends JpaRepository<HistoricoFamiliar, Long> {
}
