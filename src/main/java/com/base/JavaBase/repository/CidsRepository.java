package com.base.JavaBase.repository;

import com.base.JavaBase.entity.Cids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidsRepository extends JpaRepository<Cids, String> {
}
