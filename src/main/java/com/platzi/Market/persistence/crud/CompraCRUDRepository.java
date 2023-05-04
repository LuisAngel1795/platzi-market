package com.platzi.Market.persistence.crud;

import com.platzi.Market.domain.Purchase;
import com.platzi.Market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCRUDRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
