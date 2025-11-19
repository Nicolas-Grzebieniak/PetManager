package petmanager.model;

public class Gato extends Animal {

    private String corPelo;
    private boolean castrado;
    private boolean vacinado;

    // Construtor--------------------------------------------------------------------------------------------------
    public Gato(String nome, int idade, String corPelo, boolean castrado, boolean vacinado, String observacoes) {
        super(nome, idade, "Gato", castrado, observacoes);
        this.corPelo = corPelo;
        this.castrado = castrado;
        this.vacinado = vacinado;
    }

    public Gato(String nome, int idade, String corPelo, boolean castrado, String observacoes) {
        super(nome, idade, corPelo, castrado, observacoes);
    }
    //--------------------------------------------------------------------------------------------------------------
    //
    //Get e Set------------------------------------------------------------------------------------------------------
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

    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }
    //----------------------------------------------------------------------------------------------------------------
    //
    //Método abstrato-------------------------------------------------------------------------------------------------
    @Override
    public String emitirSom() {
        return "Miau!";
    }
    //----------------------------------------------------------------------------------------------------------------
    //
    //toString--------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Gato - " + getNome() +
                " (" + getIdade() + " anos)" +
                " | Cor do pelo: " + corPelo +
                (castrado ? " | Castrado" : " | Não castrado") +
                " | Obs: " + getObservacoes();
    }
}