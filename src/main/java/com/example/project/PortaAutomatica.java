package com.example.project;

public class PortaAutomatica extends Atuador {

    public PortaAutomatica(Integer _id, Boolean _ativo) {
        super(_id);
        this.ativo = _ativo;
    }

    public void ativa() {
        this.ativo = true;
    }

    public void desativa() {
        this.ativo = false;
    }

}
