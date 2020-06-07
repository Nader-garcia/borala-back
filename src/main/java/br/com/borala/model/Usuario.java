package br.com.borala.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Builder
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cpf;

    private String cel;

    private String email;

    @Column(name = "data_nasc")
    private Date dataNasc;

    private String estado;

    private String cidade;

    private String senha;

}
