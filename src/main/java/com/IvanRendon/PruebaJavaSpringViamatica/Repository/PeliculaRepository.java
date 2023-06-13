/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IvanRendon.PruebaJavaSpringViamatica.Repository;

import com.IvanRendon.PruebaJavaSpringViamatica.Model.Pelicula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface  PeliculaRepository extends JpaRepository<Pelicula, Integer>
{
    
    public List<Pelicula> findByNombreContaining(String nombre);
    
}
