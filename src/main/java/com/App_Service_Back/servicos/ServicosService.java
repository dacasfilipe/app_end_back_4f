package com.App_Service_Back.servicos;

import com.App_Service_Back.prestador.Prestador;
import com.App_Service_Back.prestador.PrestadorDTO;
import com.App_Service_Back.prestador.PrestadorMapper;
import com.App_Service_Back.prestador.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicosService {
    @Autowired
    private ServicosRepository servicosRepository;
    @Autowired
    private ServicosMapper servicosMapper;

    //buscando todos os servicos
    public List<ServicosDTO> findAll(){
        List<Servicos> servicos = servicosRepository.findAll();
        return servicos.stream().map(servicosMapper::toDTO).collect(Collectors.toList());
    }
    // buscar pelo id
    public ServicosDTO findById(Long id){
        Servicos servicos = servicosRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Serviço não encontrado"));
        return servicosMapper.toDTO(servicos);
    }
    //criando um novo serviço
    public ServicosDTO create(ServicosDTO servicosDTO){
        Servicos servicos = servicosMapper.toEntity(servicosDTO);
        servicos = servicosRepository.save(servicos);
        return servicosMapper.toDTO(servicos);
    }
    //update serviços
    public ServicosDTO update(Long id, ServicosDTO servicosDTO) {
        Servicos servicos = servicosRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Serviço não encontrado"));
        servicosDTO.setServico_id(id);
        servicos = servicosMapper.updateEntity(servicosDTO, servicos);
        servicos = servicosRepository.save(servicos);
        return servicosMapper.toDTO(servicos);
    }
    public void deleteById(Long id){
        servicosRepository.deleteById(id);
    }
}
