package com.monolitico.autofix.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "Reparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReparacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String Patente;
    private String Tipo_reparacion;
    private Integer Monto_total;
    private Timestamp Fecha_ingreso;
    private Timestamp Fecha_salida;
    private Timestamp Fecha_retiro;
}
