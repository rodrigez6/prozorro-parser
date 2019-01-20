package org.rodrigez.repository;

import org.rodrigez.model.domain.FeatureValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureValueRepository extends JpaRepository<FeatureValue,Integer> {
}
