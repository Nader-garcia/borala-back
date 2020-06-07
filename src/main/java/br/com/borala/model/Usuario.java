package br.com.borala.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String cel;
    private String email;
    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "data_nasc")
    private Date dataNasc;
    private String estado;
    private String cidade;
    private String senha;
}
