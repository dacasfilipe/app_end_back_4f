package com.App_Service_Back.prestador;

import com.App_Service_Back.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long prestador_id;

    @NotNull(message = "O campo NOME é requerido")
    private  String prestador_nome;

    private  String prestador_cnpj;

    @CPF
    @NotNull(message = "O campo CPF é requerido")
    private  String prestador_cpf;

    @NotNull(message = "O campo RAZAO SOCIAL é requerido")
    private  String prestador_razaoSocial;

    @NotNull(message = "O campo EMAIL é requerido")
    private  String prestador_email;

    private String prestador_senha;

    private Endereco endereco;

//    private List<Servicos> servicos;
//
//    private List<Telefone> telefones;
}
