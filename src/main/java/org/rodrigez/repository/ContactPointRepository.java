package org.rodrigez.repository;

import org.rodrigez.model.domain.ContactPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPointRepository extends JpaRepository<ContactPoint,Integer> {
}
