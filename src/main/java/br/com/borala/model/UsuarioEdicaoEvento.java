package br.com.borala.model;

import br.com.borala.vo.InscreverEventoVO;
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
public class UsuarioEdicaoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private EdicaoEvento edicaoEvento;

    private Integer classificacao;

}
