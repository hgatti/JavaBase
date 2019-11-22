package com.base.JavaBase.repository;

import com.base.JavaBase.entity.PossuiCids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PossuiCidsRepository extends JpaRepository<PossuiCids, Long> {
}
