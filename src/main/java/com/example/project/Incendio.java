package com.example.project;

public class Incendio extends Sensor {
    private Boolean status;

    public Incendio(Boolean _status) {
        this.status = _status;
    }

    public Boolean checaSensor() {
        return this.status;
    }
}
