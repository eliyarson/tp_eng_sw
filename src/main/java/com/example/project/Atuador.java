package com.example.project;

public class Atuador {
    private Integer id;
    protected Boolean ativo;

    // Construtor
    public Atuador(Integer _id) {
        this.id = _id;
    }

    // Getter
    public Integer getId() {
        return this.id;
    }

    public Boolean estaAtivo() {
        return this.ativo;
    }

    public void ativa() {
        this.ativo = true;
    }

    public void desativa() {
        this.ativo = false;
    }


}
