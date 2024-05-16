package com.App_Service_Back.cliente;

import com.App_Service_Back.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    //cria uma interface para ser implementada
}
