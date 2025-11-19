package petmanager.model;

public class Gato extends Animal {

    private String corPelo;
    private boolean castrado;
    private boolean vacinado; // <-- NOVO ATRIBUTO

    // Construtor atualizado para incluir vacinado
    public Gato(String nome, int idade, String corPelo, boolean castrado, boolean vacinado, String observacoes) {
        super(nome, idade, "Gato", observacoes);
        this.corPelo = corPelo;
        this.castrado = castrado;
        this.vacinado = vacinado; // <-- NOVO
    }

    // GETTERS E SETTERS
    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    // NOVO GETTER E SETTER
    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }
    // FIM NOVO GETTER E SETTER

    @Override
    public String emitirSom() {
        return "Miau!";
    }

    @Override
    public String toString() {
        return "Gato - " + getNome() +
                " (" + getIdade() + " anos)" +
                " | Cor do pelo: " + corPelo +
                (castrado ? " | Castrado" : " | Não castrado") +
                " | Obs: " + getObservacoes();
    }
}