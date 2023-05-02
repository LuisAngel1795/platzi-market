package com.platzi.Market.persistence;

import com.platzi.Market.persistence.crud.ProductoCRUDRepository;
import com.platzi.Market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCRUDRepository productoCRUDRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCRUDRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCRUDRepository.findByIdCategoria(idCategoria);
    }
}
