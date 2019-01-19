package org.rodrigez.repository;

import org.rodrigez.model.domain.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderRepository extends JpaRepository<Tender,String> {
}
