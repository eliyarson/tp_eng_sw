package com.example.project;

public class Atuador {
    private Integer id;
    private Boolean ativado;

    // Construtor
    public Atuador(Integer _id, Boolean _ativado) {
        this.id = _id;
        this.ativado = _ativado;
    }

    // Getter
    public Integer getId() {
        return this.id;
    }

    public Boolean estaAtivo() {
        return this.ativado;
    }
}
