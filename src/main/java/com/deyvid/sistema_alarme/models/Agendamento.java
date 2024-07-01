package com.deyvid.sistema_alarme.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String descricao;
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
