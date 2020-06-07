package br.com.borala.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;

@Builder
@Data
@Entity
public class EdicaoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Evento evento;

    @Column(name = "data_evento")
    private ZonedDateTime dataEvento;

}
