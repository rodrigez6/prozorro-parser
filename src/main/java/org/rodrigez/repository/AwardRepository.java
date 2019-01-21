package org.rodrigez.repository;

import org.rodrigez.model.domain.Award;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Award, String> {
}
