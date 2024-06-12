package com.App_Service_Back.endereco;

import com.App_Service_Back.categoria.CategoriaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController //habilitar o REST
@RequestMapping("/endereco") // localhost:8080/endereco
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
    @GetMapping //retorna uma lista de endereco
    public ResponseEntity<List<EnderecoDTO>> getAllEnderecos(){
        List<EnderecoDTO> enderecoDTO = enderecoService.findAll();
        return ResponseEntity.ok(enderecoDTO);
    }
    @GetMapping("/{id}") //localhost:8080/enderecos/1 pegar por id
    public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable Long id){
        EnderecoDTO enderecoDTO = enderecoService.findById(id);
        return ResponseEntity.ok(enderecoDTO);
    }
    @PostMapping //salvar um endereco no banco de dados
    public ResponseEntity<EnderecoDTO> createEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO createEnderecoDTO = enderecoService.create(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEnderecoDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable Long id, @Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO updateEnderecoDTO = enderecoService.update(id, enderecoDTO);
        return ResponseEntity.ok(updateEnderecoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id){
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
