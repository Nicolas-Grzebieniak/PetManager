package petmanager.model;

public abstract class Animal {
    private String nome;
    private int idade;
    private String tipo;
    private Double peso;

    public Animal(String nome, int idade, String tipo) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
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
}
