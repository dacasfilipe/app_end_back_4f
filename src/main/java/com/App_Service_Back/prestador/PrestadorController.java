package com.App_Service_Back.prestador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController //habilitar o REST
@RequestMapping("/prestador") // localhost:8080/prestador
public class PrestadorController {
    @Autowired
    private PrestadorService prestadorService;
    @GetMapping //retorna uma lista de prestador
    public ResponseEntity<List<PrestadorDTO>> getAllPrestadores(){
        List<PrestadorDTO> prestadorDTO = prestadorService.findAll();
        return ResponseEntity.ok(prestadorDTO);
    }
    @GetMapping("/{id}") //localhost:8080/prestador/1 pegar por id
    public ResponseEntity<PrestadorDTO> getPrestadorById(@PathVariable Long id){
        PrestadorDTO prestadorDTO = prestadorService.findById(id);
        return ResponseEntity.ok(prestadorDTO);
    }
    @PostMapping //salvar um prestador no banco de dados
    public ResponseEntity<PrestadorDTO> createPrestador(@Valid @RequestBody PrestadorDTO prestadorDTO){
        PrestadorDTO createPrestadorDTO = prestadorService.create(prestadorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPrestadorDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PrestadorDTO> updatePrestador(@PathVariable Long id, @Valid @RequestBody PrestadorDTO prestadorDTO){
        PrestadorDTO updatePrestadorDTO = prestadorService.update(id, prestadorDTO);
        return ResponseEntity.ok(updatePrestadorDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestador(@PathVariable Long id){
        prestadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
