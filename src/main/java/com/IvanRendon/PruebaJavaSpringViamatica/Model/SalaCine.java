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
@Table(schema = "sala_cine")
@Builder
@Getter
@Setter
@NoArgsConstructor
public class SalaCine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sala;
    @Column
    private String nombre;
    @Column
    private String estado;

    public SalaCine(int id_sala, String nombre, String estado) {
        this.id_sala = id_sala;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    
}
