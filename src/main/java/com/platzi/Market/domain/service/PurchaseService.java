package com.platzi.Market.domain.service;

import com.platzi.Market.domain.Purchase;
import com.platzi.Market.domain.repository.PurcahseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurcahseRepository purcahseRepository;
    public List<Purchase> getAll(){
        return purcahseRepository.getAll();
    }
    public Optional<List<Purchase>> getByClient(String clientId){
        return purcahseRepository.getByClient(clientId);
    }
    public Purchase save(Purchase purchase){
     return purcahseRepository.save(purchase);
    }
}
