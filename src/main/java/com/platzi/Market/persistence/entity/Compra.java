package com.platzi.Market.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="compras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compra")
    private Integer idCompra;
    @Column(name="id_cliente")
    private Integer idCliente;
     private LocalDateTime fecha;
     @Column(name="medio_pago")
    private String medioPago;
     private String comentario;
     private String estado;

     @ManyToOne
     @JoinColumn(name="id_cliente", insertable = false, updatable = false)
     private Cliente cliente;

     @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
     private List<ComprasProducto> productos;
}
