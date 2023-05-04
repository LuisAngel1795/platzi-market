package com.platzi.Market.persistence.mapper;

import com.platzi.Market.domain.Purchase;
import com.platzi.Market.persistence.entity.Cliente;
import com.platzi.Market.persistence.entity.Compra;
import com.platzi.Market.persistence.entity.Producto;
import lombok.Lombok;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={Lombok.class, PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source ="idCompra" ,target = "purchaseId"),
            @Mapping(source ="idCliente" ,target = "clienteId"),
            @Mapping(source ="fecha" ,target = "date"),
            @Mapping(source ="medioPago" ,target = "paymentMethod"),
            @Mapping(source ="comentario" ,target = "comment"),
            @Mapping(source ="estado" ,target = "state"),
            @Mapping(source ="productos" ,target = "items"),

    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);


}
