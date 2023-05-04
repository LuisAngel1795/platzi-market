package com.platzi.Market.persistence;

import com.platzi.Market.domain.Purchase;
import com.platzi.Market.domain.repository.PurcahseRepository;
import com.platzi.Market.persistence.crud.CompraCRUDRepository;
import com.platzi.Market.persistence.entity.Compra;
import com.platzi.Market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurcahseRepository {
    @Autowired
    private CompraCRUDRepository compraCRUDRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>)compraCRUDRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCRUDRepository.findByIdCliente(clientId)
                .map(purchases -> purchaseMapper.toPurchases(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return purchaseMapper.toPurchase(compraCRUDRepository.save(compra));
    }
}
