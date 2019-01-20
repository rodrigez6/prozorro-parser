package org.rodrigez.repository;

import org.rodrigez.model.domain.LotValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotValueRepository extends JpaRepository<LotValue,Integer> {
}
