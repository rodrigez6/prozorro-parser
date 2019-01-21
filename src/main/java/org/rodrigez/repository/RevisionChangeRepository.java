package org.rodrigez.repository;

import org.rodrigez.model.domain.RevisionChange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionChangeRepository extends JpaRepository<RevisionChange, Integer> {
}
