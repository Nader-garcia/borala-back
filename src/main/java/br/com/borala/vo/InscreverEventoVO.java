package br.com.borala.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class InscreverEventoVO {

    private Integer usuarioId;

    private Integer edicaoEventoId;

}
