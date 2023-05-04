package com.platzi.Market.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="compras_productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;
    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name="id_compra", insertable = false,updatable = false)
    private Compra compra;
    @ManyToOne
    @JoinColumn(name="id_producto", insertable = false,updatable = false)
    private Producto producto;
}
