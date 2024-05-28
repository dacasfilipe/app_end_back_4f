package com.App_Service_Back.servicos;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ServicosRepository extends JpaRepository<Servicos,Long> {
    //cria uma interface para ser implementada
}
