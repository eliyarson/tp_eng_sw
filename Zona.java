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
    public void checaSensores() {
        // Loopa os sensores
        Integer valorSensor = 0;
        for (int i = 0; i < sensores.size(); i++) {
            // checa sensor
            Boolean status = sensores.get(i).checaSensor();
            if (status == true) {
                this.estado = Estado.FOGO;
                break;
            } else {
                valorSensor = -1;
            }
        }
        // TODO: implementar classe sensor

        if (valorSensor == -1) {
            this.estado = Estado.SEM_FOGO;
        } else {
            this.estado = Estado.SEM_FOGO;
        }

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

    public Boolean temPessoas() {
        // Checa se tem pessoas
        // Utiliza sensor de Presença
        return false;
    }
}