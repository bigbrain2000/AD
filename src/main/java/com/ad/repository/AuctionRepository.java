package com.ad.repository;

import com.ad.model.Auction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends ReactiveCrudRepository<Auction, Integer> {
}