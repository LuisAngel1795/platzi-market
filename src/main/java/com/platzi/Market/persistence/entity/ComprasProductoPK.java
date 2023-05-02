package com.platzi.Market.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComprasProductoPK implements Serializable {
    @Column(name="id_compra")
    private Integer idCompra;
    @Column(name="id_producto")
    private Integer idProducto;
}
