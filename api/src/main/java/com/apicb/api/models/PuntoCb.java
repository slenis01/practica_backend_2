package com.apicb.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

@Entity
@Table(name = "db_cb")
public class PuntoCb {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "codigo_punto", nullable = false, unique = true)
    @Digits(integer = 5, fraction = 0, message = "El código debe tener 5 dígitos")
    private Integer codigoPunto;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "red")
    private String red;
    
    // Constructor vacío
    public PuntoCb() {}
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getCodigoPunto() {
        return codigoPunto;
    }
    
    public void setCodigoPunto(Integer codigoPunto) {
        this.codigoPunto = codigoPunto;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getRed() {
        return red;
    }
    
    public void setRed(String red) {
        this.red = red;
    }
} 