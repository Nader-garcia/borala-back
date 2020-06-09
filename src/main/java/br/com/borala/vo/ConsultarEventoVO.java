package br.com.borala.vo;

import br.com.borala.model.EdicaoEvento;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ConsultarEventoVO {

    private Integer id;

    private String titulo;

    private String categoria;

    private String organizador;

    private String endereco;

    private String cidade;

    private Integer capacidade;

    private Double valor;

    private String dataEvento;

    private Integer participantes;

    public static ConsultarEventoVO valueOf(EdicaoEvento edicaoEvento) {
        return ConsultarEventoVO.builder()
                .capacidade(edicaoEvento.getEvento().getCapacidade())
                .categoria(edicaoEvento.getEvento().getCategoria().getDescricao())
                .cidade(edicaoEvento.getEvento().getCidade())
                .dataEvento(edicaoEvento.getDataEvento().toLocalDateTime().toString())
                .endereco(edicaoEvento.getEvento().getEndereco())
                .id(edicaoEvento.getId())
                .organizador(edicaoEvento.getEvento().getOrganizador().getNome())
                .titulo(edicaoEvento.getEvento().getTitulo())
                .valor(edicaoEvento.getEvento().getValor())
                .build();
    }

}
