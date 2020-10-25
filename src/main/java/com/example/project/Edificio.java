package com.example.project;

// Edificio.java
import java.util.List;

public class Edificio {

    // Atributos
    private Integer id;
    private String nome;
    private List<Zona> zonas;
    private Estado estado;
    private Boolean temIndicadoresDeEmergencia;

    // Construtor da Classe
    public Edificio(Integer _id, String _nome, List<Zona> _zonas, Estado _estado, Boolean _temIndicadores) {
        this.id = _id;
        this.nome = _nome;
        this.zonas = _zonas;
        this.estado = _estado;
        this.temIndicadoresDeEmergencia = _temIndicadores;
    }

    // Métodos
    // Getters
    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public List<Zona> getZonas() {
        return this.zonas;
    }

    public Estado getEstado() {
        return this.estado;
    }

    // Não possue setters.
    // As zonas serão carregadas do BD e settadas pelo Construtor principal da
    // Classe.
    // Não poderão portanto ser modificadas.

    // Métodos Principais
    public static void importaBD() {
        // Importa código do BD
        // Parse no JSON e Set das Instâncias das Zonas

        // código

        // chama o Construtor.

        // construtor
    }

    public void verificaZonas() {
        for (int i = 0; i < zonas.size(); i++) {
            Zona zona = zonas.get(i);
            Boolean atuador = zona.checaAtuadores();
            Estado estadoZona = zona.checaSensores();
            Boolean pessoas = zona.getPessoas();

            switch (estadoZona) {

                case CHECANDO:
                    break;
                case FOGO:
                    tocaAlarmeIncendio(zona);
                    ativaIndicadoresEmergencia();
                    if (zona.getCritico() == true) {
                        acionaEmergencia();
                    }
                    if (pessoas == false) {
                        combateIncendio(zona);
                    }
                    break;
                case INVASAO:
                    combateInvasao(zona);
                    break;
                case SEM_FOGO:
                    if (atuador == true) {
                        zona.desativaAtuadores();
                    }
                    break;

            }

        }
    }

    public void tocaAlarmeIncendio(Zona zona) {
        zona.ativaAlarmes();
    }

    public static void acionaEmergencia() {
        // Liga para 193
    }

    public void ativaIndicadoresEmergencia() {
        if (temIndicadoresDeEmergencia) {
            // ativa
        } else {
        }
    }

    public void combateIncendio(Zona zona) {
        zona.ativaAtuadores();
    }

    public void combateInvasao(Zona zona) {
        // Dispara Alarme de Invasao
        // Chama a Policia
    }
}
