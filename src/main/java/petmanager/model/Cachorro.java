package petmanager.model;

public class Cachorro extends Animal {

    private String raca;
    private boolean vacinado;
    private boolean castrado;
    private String corPelo;

    // Construtor ---------------------------------------------------------------------------------------------------
    public Cachorro(String nome, int idade, String raca, boolean vacinado, String corPelo) {
        super(nome, idade, "Cachorro", true, "");
        this.raca = raca;
        this.vacinado = vacinado;
        this.castrado = castrado;
        this.corPelo = corPelo;
    }
    //----------------------------------------------------------------------------------------------------------------
    //
    //Get e Set-------------------------------------------------------------------------------------------------------
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
    //----------------------------------------------------------------------------------------------------------------
    //
    //Método abstrato-------------------------------------------------------------------------------------------------
    @Override
    public String emitirSom() {
        return "Au Au";
    }
    //----------------------------------------------------------------------------------------------------------------
    //
    //toString acesso aos dados----------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Cachorro - " + getNome() +
                " (" + getIdade() + " anos)" +
                " | Raça: " + raca +
                (vacinado ? " | Vacinado" : " | Não vacinado") +
                " | Obs: " + getObservacoes();
    }
}