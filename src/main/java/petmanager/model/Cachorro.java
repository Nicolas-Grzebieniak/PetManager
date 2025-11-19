package petmanager.model;

public class Cachorro extends Animal {

    private String raca;
    private boolean vacinado;
    private boolean castrado;  // <-- NOVO ATRIBUTO
    private String corPelo;    // <-- NOVO ATRIBUTO

    // Construtor atualizado para incluir castrado e corPelo
    public Cachorro(String nome, int idade, String raca, boolean vacinado, boolean castrado, String corPelo, String observacoes) {
        super(nome, idade, "Cachorro", observacoes);
        this.raca = raca;
        this.vacinado = vacinado;
        this.castrado = castrado;
        this.corPelo = corPelo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    // NOVOS GETTERS E SETTERS
    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }
    // FIM NOVOS GETTERS E SETTERS

    @Override
    public String emitirSom() {
        return "Au Au";
    }

    @Override
    public String toString() {
        return "Cachorro - " + getNome() +
                " (" + getIdade() + " anos)" +
                " | Raça: " + raca +
                (vacinado ? " | Vacinado" : " | Não vacinado") +
                " | Obs: " + getObservacoes();
    }
}