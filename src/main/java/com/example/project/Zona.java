package com.example.project;

import java.util.List;

public class Zona {

    // Atributos
    private Integer idZona;
    private Boolean critico;
    private List<Sensor> sensores;
    private List<Atuador> atuadores;
    private List<Alarme> alarmes;
    private Estado estado;
    private Boolean temPessoas;

    // Construtor

    public Zona(Integer _id, Boolean _critico, List<Sensor> _sensores, List<Atuador> _atuadores, List<Alarme> _alarmes,
            Boolean _temPessoas) {
        this.idZona = _id;
        this.critico = _critico;
        this.sensores = _sensores;
        this.atuadores = _atuadores;
        this.alarmes = _alarmes;
        this.temPessoas = _temPessoas;
    }

    // Getters

    public Integer getId() {
        return this.idZona;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public Boolean getCritico() {
        return this.critico;
    }

    public List<Sensor> getSensores() {
        return this.sensores;
    }

    public List<Atuador> getAtuadores() {
        return this.atuadores;
    }

    public List<Alarme> getAlarmes() {
        return this.alarmes;
    }

    public Boolean getPessoas() {
        return this.temPessoas;
    }

    // Métodos
    public Estado checaSensores() {
        // Loopa os sensores
        Integer valorSensor = 0;
        this.estado = Estado.CHECANDO;
        for (int i = 0; i < sensores.size(); i++) {
            Sensor sensor = sensores.get(i);
            Boolean status = sensor.checaSensor();
            if (status) {

                if (sensor instanceof Incendio) {
                    valorSensor++;
                } else if (sensor instanceof Presenca) {
                    this.temPessoas = true;
                } else if (sensor instanceof Invasao) {
                    valorSensor--;
                }

            }
        }

        if (valorSensor == 0 || valorSensor == 1) {
            this.estado = Estado.SEM_FOGO;
            return this.estado;
        } else if (valorSensor > 1) {
            this.estado = Estado.FOGO;
            return this.estado;
        } else if (valorSensor < -1) {
            this.estado = Estado.INVASAO;
            return this.estado;
        } else {
            return this.estado;
        }

    }

    public Boolean checaAtuadores() {
        for (int i = 0; i < atuadores.size(); i++) {
            Atuador atuador = atuadores.get(i);
            Boolean ativo = atuador.estaAtivo();
            if (ativo) {
                return true;
            }
        }
        return false;
    }

    public void ativaAtuadores() {
        for (int i = 0; i < atuadores.size(); i++) {
            Atuador atuador = atuadores.get(i);
            Boolean ativo = atuador.estaAtivo();
            if (ativo == false) {
                atuador.ativa();
            }
        }
    }

    public void desativaAtuadores() {
        for (int i = 0; i < atuadores.size(); i++) {
            Atuador atuador = atuadores.get(i);
            Boolean ativo = atuador.estaAtivo();
            if (ativo) {
                atuador.desativa();
            }
        }
    }

    public void ativaAlarmes() {
        for (int i = 0; i < alarmes.size(); i++) {
            Alarme alarme = alarmes.get(i);
            alarme.ativa();
        }
    }

}
