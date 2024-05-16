package com.App_Service_Back.servicos;

import com.App_Service_Back.agendamento.Agendamento;
import com.App_Service_Back.categoria.Categoria;
import com.App_Service_Back.endereco.Endereco;
import com.App_Service_Back.prestador.Prestador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicos")
public class Servicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer servico_id;
    private String servico_nome;
    private Double servico_preco;
    private String servico_descricao;
    private String servico_informacoesExtras;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_categorias_id", nullable = false)
    private Categoria categorias;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "servico_prestadores_id", nullable = false)
//    private Prestador prestadores;
//    @OneToMany(mappedBy = "agendamento_id", fetch = FetchType.LAZY)
//    private List<Agendamento> agendamentos;
    private String servico_classificacao;


}
