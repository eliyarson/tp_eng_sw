package com.example.project;

public class Alarme {
    private Integer id;
    protected Boolean ativo;

    public Integer getId() {
        return this.id;
    }

    public Alarme(Integer _id, Boolean _ativo) {
        this.id = _id;
        this.ativo = _ativo;
    }

    public Boolean checaAlarme() {
        Boolean status = true;
        return status;
    }

    public void ativa() {
        this.ativo = true;
    }

    public void desativa() {
        this.ativo = false;
    }

}
