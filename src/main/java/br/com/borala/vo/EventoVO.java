package br.com.borala.vo;

import br.com.borala.model.EdicaoEvento;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder
@Data
public class EventoVO {

    private Integer id;

    private String titulo;

    private String categoria;

    private String organizador;

    private String endereco;

    private String cidade;

    private Integer capacidade;

    private Double valor;

    private ZonedDateTime dataEvento;

    public static EventoVO valueOf(EdicaoEvento edicaoEvento) {
        return EventoVO.builder()
                .capacidade(edicaoEvento.getEvento().getCapacidade())
                .categoria(edicaoEvento.getEvento().getCategoria().getDescricao())
                .cidade(edicaoEvento.getEvento().getCidade())
                .dataEvento(edicaoEvento.getDataEvento())
                .endereco(edicaoEvento.getEvento().getEndereco())
                .id(edicaoEvento.getId())
                .organizador(edicaoEvento.getEvento().getOrganizador().getNome())
                .titulo(edicaoEvento.getEvento().getTitulo())
                .valor(edicaoEvento.getEvento().getValor())
                .build();
    }

}
