package com.platzi.Market.persistence.mapper;

import com.platzi.Market.domain.Product;
import com.platzi.Market.domain.repository.ProductRepository;
import com.platzi.Market.persistence.entity.Producto;
import lombok.Lombok;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, Lombok.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),

    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);
@InheritInverseConfiguration
@Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
