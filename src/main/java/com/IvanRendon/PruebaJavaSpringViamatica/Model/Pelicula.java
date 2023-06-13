/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IvanRendon.PruebaJavaSpringViamatica.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author usuario
 */

@Entity
@Table(schema="pelicula")
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Pelicula {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pelicula;
    @Column
    private String nombre;
    @Column
    private int duracion;

    public Pelicula(int id_pelicula, String nombre, int duracion) {
        this.id_pelicula = id_pelicula;
        this.nombre = nombre;
        this.duracion = duracion;
    }
    
    
    
}
