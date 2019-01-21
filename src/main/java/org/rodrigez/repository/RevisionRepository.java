package org.rodrigez.repository;

import org.rodrigez.model.domain.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision, String> {
}
