package com.example.project;

public class Invasao extends Sensor {
    private Boolean status;

    public Invasao(Boolean _status) {
        this.status = _status;
    }

    public Boolean checaSensor() {
        Boolean status = this.status;
        return status;
    }
}
