package com.base.JavaBase.repository;

import com.base.JavaBase.entity.Atende;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendeRepository extends JpaRepository<Atende, Long> {
}
