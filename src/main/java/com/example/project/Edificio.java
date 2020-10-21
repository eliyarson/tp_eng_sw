package com.example.project;

// Edificio.java
import java.util.List;

public class Edificio {

    // Atributos
    private Integer id;
    private String nome;
    private List<Zona> zonas;
    private Estado estado;

    // Construtor da Classe
    public Edificio(Integer _id, String _nome, List<Zona> _zonas) {
        this.id = _id;
        this.nome = _nome;
        this.zonas = _zonas;
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
            Integer idZona = zona.getId();
            zona.checaSensores();
            Boolean atuador = zona.checaAtuadores();
            Estado estadoZona = zona.getEstado();
            if (estadoZona == Estado.FOGO) {
                tocaSirene();
                ativaIndicadores();
                combateIncendio(idZona);
                if (zona.getCritico() == true) {
                    acionaEmergencia();
                }
            } else if (estadoZona == Estado.SEM_FOGO && atuador == true) {
                zona.desativaAtuadores();
            }
        }
    }

    public static void tocaSirene() {
        // Toca Sirene
    }

    public static void acionaEmergencia() {
        // Liga para 193
    }

    public void ativaIndicadores() {
        // Ligar os Sinalizadores de Caminho
        // Passa o ID da Zona e aciona
    }

    public void combateIncendio(Integer idZona) {
        // Liga os sprinklers
        // Passa o ID da Zna
    }
}
