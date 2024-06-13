package com.App_Service_Back.prestador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorRepository extends JpaRepository<Prestadores,Long> {
    //cria uma interface para ser implementada
}
