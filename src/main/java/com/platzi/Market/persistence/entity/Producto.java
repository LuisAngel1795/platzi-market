package com.platzi.Market.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProducto;
    private String nombre;
    @Column(name="id_categoria")
    private Integer idCategoria;
    @Column(name="codigo_barras")
    private String codigoBarras;
    @Column(name="precio_venta")
    private Double precioVenta;
    @Column(name="cantidad_stock")
    private Integer cantidadStock;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false,updatable = false)
    private Categoria categoria;

}
