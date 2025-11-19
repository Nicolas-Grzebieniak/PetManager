package petmanager.model;

public abstract class Animal {
    private String nome;
    private int idade;
    private String tipo;
    private double peso;
    private String observacoes;

    //Construtor -----------------------------------------------------------------------------------------------
    public Animal(String nome, int idade, String tipo, boolean castrado, String observacoes) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.observacoes = observacoes;
        this.peso = 0.0; //inicio zerado
    }
    //--------------------------------------------------------------------------------------------------------------
    //
    // Getters e Setters (As portas de acesso)------------------------------------------------------------------------
    public String getNome() {
        return nome;
    } // get: Permite que outras classes leiam o valor

    public void setNome(String nome) {
        this.nome = nome;
    } // set: Permite alterar o valor.

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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    //----------------------------------------------------------------------------------------------------------------
    //
    // Método abstrato------------------------------------------------------------------------------------------------
    public abstract String emitirSom();
    //----------------------------------------------------------------------------------------------------------------
    //
    //toString--------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return tipo + " - " + nome + " (" + idade + " anos)" +
                (observacoes != null && !observacoes.isEmpty() ? " | Obs: " + observacoes : ""); //é um "if/else" numa linha só.
    }
}


