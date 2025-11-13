package petmanager.model;

public class Gato extends Animal{
    private String corPelo;
    private boolean castrado;

    public Gato(String nome, int idade, String corPelo, boolean castrado) {
        super(nome, idade, "Gato");
        this.corPelo = corPelo;
        this.castrado = castrado;
    }

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

    @Override
    public String emitirSom() {
        return "Miau!";
    }

    @Override
    public String toString() {
        return super.toString() + " | Cor pelo: " + corPelo + (castrado ? " | Castrado ✅" : " | Não castrado ⚠\uFE0F");
    }
}
