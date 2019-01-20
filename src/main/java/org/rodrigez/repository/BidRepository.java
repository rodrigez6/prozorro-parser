package org.rodrigez.repository;

import org.rodrigez.model.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid,String> {
}
