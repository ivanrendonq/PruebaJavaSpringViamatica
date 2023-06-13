/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IvanRendon.PruebaJavaSpringViamatica.Repository;

import com.IvanRendon.PruebaJavaSpringViamatica.Model.Pelicula;
import com.IvanRendon.PruebaJavaSpringViamatica.Model.PeliculaSalacine;
import java.util.Date;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface PeliculaSalaCineRepository extends JpaRepository<PeliculaSalacine, Integer> {
    
    @Query("SELECT psc.pelicula FROM PeliculaSalacine psc WHERE psc.fecha_publicacion = :fechaPublicacion")
    public List<Pelicula> getPeliculaEnFecha(@Param("fechaPublicacion") Date fecha_publicacion);
    
    
    @Query("SELECT COUNT(psc) FROM PeliculaSalacine psc WHERE psc.salaCine.id_sala = :id_sala_cine")
    public int getCantidadDeSalaCine(@Param("id_sala_cine") int id_sala_cine );
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
