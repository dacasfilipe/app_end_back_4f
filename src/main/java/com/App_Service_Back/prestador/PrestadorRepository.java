package com.App_Service_Back.prestador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorRepository extends JpaRepository<Prestador,Long> {
    //cria uma interface para ser implementada
}
