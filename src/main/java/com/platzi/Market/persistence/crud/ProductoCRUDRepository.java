package com.platzi.Market.persistence.crud;

import com.platzi.Market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCRUDRepository extends CrudRepository<Producto,Integer> {
    public List<Producto> findByIdCategoria(int idCategoria);
}
