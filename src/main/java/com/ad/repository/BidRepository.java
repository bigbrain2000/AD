package com.ad.repository;

import com.ad.model.Bid;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends ReactiveCrudRepository<Bid, Integer> {
}