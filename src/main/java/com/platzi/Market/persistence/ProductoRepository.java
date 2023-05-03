package com.platzi.Market.persistence;

import com.platzi.Market.domain.Product;
import com.platzi.Market.domain.repository.ProductRepository;
import com.platzi.Market.persistence.crud.ProductoCRUDRepository;
import com.platzi.Market.persistence.entity.Producto;
import com.platzi.Market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCRUDRepository productoCRUDRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos= (List<Producto>)productoCRUDRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCRUDRepository.findByIdCategoria(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCRUDRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCRUDRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(productoCRUDRepository.save(mapper.toProducto(product)));
    }

    @Override
    public void delete(int idProducto){
        productoCRUDRepository.deleteById(idProducto);
    }
}
