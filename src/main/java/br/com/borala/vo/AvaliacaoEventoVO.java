package br.com.borala.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AvaliacaoEventoVO {

    private Integer edicaoEventoId;

    private Integer usuarioId;

    private Integer avaliacao;

}
