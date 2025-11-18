package petmanager.model;

public abstract class Animal {
    private String nome;
    private int idade;
    private String tipo;
    private double peso;
    private String observacoes;

    // ✔ Construtor corrigido com observações
    public Animal(String nome, int idade, String tipo, String observacoes) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.observacoes = observacoes;
        this.peso = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // ✔ GETTER e SETTER de OBSERVAÇÕES
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // Método abstrato
    public abstract String emitirSom();

    @Override
    public String toString() {
        return tipo + " - " + nome + " (" + idade + " anos)" +
                (observacoes != null && !observacoes.isEmpty() ? " | Obs: " + observacoes : "");
    }
}


