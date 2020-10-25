package com.example.project;

public class Presenca extends Sensor {
    private Boolean status;

    public Presenca(Boolean _status) {
        this.status = _status;
    }

    public Boolean checaSensor() {
        return this.status;
    }
}