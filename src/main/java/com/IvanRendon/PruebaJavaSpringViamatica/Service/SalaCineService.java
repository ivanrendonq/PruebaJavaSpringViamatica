/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IvanRendon.PruebaJavaSpringViamatica.Service;

import com.IvanRendon.PruebaJavaSpringViamatica.Model.SalaCine;
import com.IvanRendon.PruebaJavaSpringViamatica.Repository.SalaCineRepository;
import java.util.List;
import lombok.Builder;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
@Builder
public class SalaCineService {
 
    private final SalaCineRepository salaCineRepository;
    
    public List<SalaCine> getSalaCinePorNombre(String nombre)
    {
        return salaCineRepository.findByNombre(nombre);
    }
    
    
}
