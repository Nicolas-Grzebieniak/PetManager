package petmanager.model;

public class Cachorro extends Animal{
    private String raca;
    private boolean vacinado;

    public Cachorro(String nome, int idade, String raca, boolean vacinado) {
        super(nome, idade, "Cachorro");
        this.raca = raca;
        this.vacinado = vacinado;
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

    @Override
    public String emitirSom() {
        return "Au Au";
    }

    @Override
    public String toString() {
        return super.toString() + " | Raça: " + raca + (vacinado ? " | Vacinado ✅" : " | Não vacinado ⚠\uFE0F");
    }
}
