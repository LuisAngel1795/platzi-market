package com.platzi.Market.domain.repository;

import com.platzi.Market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurcahseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
