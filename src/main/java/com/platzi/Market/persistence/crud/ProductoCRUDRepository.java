package com.platzi.Market.persistence.crud;

import com.platzi.Market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCRUDRepository extends CrudRepository<Producto,Integer> {
    public List<Producto> findByIdCategoria(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
