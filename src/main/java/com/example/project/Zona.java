package com.example.project;

import java.util.List;

public class Zona {

    // Atributos
    private Integer idZona;
    private Boolean critico;
    private List<Sensor> sensores;
    private List<Atuador> atuadores;
    private Estado estado;

    // Construtor

    public Zona(Integer _id, Boolean _critico, List<Sensor> _sensores, List<Atuador> _atuadores) {
        this.idZona = _id;
        this.critico = _critico;
        this.sensores = _sensores;
        this.atuadores = _atuadores;
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

    // Métodos
    public Boolean checaSensores() {
        // Loopa os sensores
        Integer valorSensor = 0;
        this.estado = Estado.CHECANDO;
        for (int i = 0; i < sensores.size(); i++) {
            Sensor sensor = sensores.get(i);
            Boolean status = sensor.checaSensor();
            if (status == true && sensor instanceof Incendio) {
                valorSensor++;
            } else if (status == true && sensor instanceof Invasao) {
                valorSensor = -1;
            }
        }

        if (valorSensor == 0) {
            this.estado = Estado.SEM_FOGO;
            return false;
        } else if (valorSensor > 1) {
            this.estado = Estado.FOGO;
            return true;
        } else if (valorSensor < 0) {
            this.estado = Estado.INVASAO;
            return true;
        } else {
            return false;
        }

    }

    public Boolean checaAtuadores() {
        // Retorna True se atuador Ativo
        // Falso se inativo
        return false;
    }

    public void ativaAtuadores() {
        // Ativa atuador.
        // Se pessoas
        Boolean pessoas = temPessoas();
        if (pessoas == true) {
        } else {
            // ativa atuadores
        }
    }

    public void desativaAtuadores() {
        // Desliga atuadores
    }

    public Boolean temPessoas() {
        // Checa se tem pessoas
        // Utiliza sensor de Presença
        return false;
    }
}
