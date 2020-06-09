package br.com.borala.vo;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class InsertEventoVO {

    private Integer id;

    private String titulo;

    private Integer categoriaId;

    private Integer organizadorId;

    private String endereco;

    private String cidade;

    private Integer capacidade;

    private ZonedDateTime dataEvento;

    private Double valor;

    private Boolean publico;

    private Boolean semanal;

}
