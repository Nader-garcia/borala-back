package br.com.borala.model;

import br.com.borala.vo.InsertEventoVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @ManyToOne
    private CategoriaEvento categoria;

    @ManyToOne
    private Usuario organizador;

    private String endereco;

    private String cidade;

    private Integer capacidade;

    private Double valor;

    private Boolean publico;

    public static Evento valueOf(InsertEventoVO insertEventoVO) {
        return Evento.builder()
                .capacidade(insertEventoVO.getCapacidade())
                .categoria(CategoriaEvento.builder()
                        .id(insertEventoVO.getCategoriaId())
                        .build())
                .cidade(insertEventoVO.getCidade())
                .endereco(insertEventoVO.getEndereco())
                .organizador(Usuario.builder()
                        .id((insertEventoVO.getOrganizadorId()))
                        .build())
                .publico(insertEventoVO.getPublico())
                .titulo(insertEventoVO.getTitulo())
                .valor(insertEventoVO.getValor())
                .build();
    }

}
