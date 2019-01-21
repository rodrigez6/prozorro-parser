package org.rodrigez.repository;

import org.rodrigez.model.domain.Cancellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancellationRepository extends JpaRepository<Cancellation, String> {
}
