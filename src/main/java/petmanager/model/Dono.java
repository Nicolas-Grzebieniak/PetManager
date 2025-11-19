package petmanager.model;
import java.util.ArrayList;


//Importante caiu em desuso!!!



public class Dono {
    private String nome;
    private String telefone;
    private ArrayList<Animal> listaAnimais;

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public ArrayList<Animal> getListaAnimais() {
        return listaAnimais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setListaAnimais(ArrayList<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }

    public Dono(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.listaAnimais = new ArrayList<>();


    }

    public void adicionarAnimal(Animal a) {
        listaAnimais.add(a);
    }
    public void removerAnimal(String nome){
        for (int i = 0; i < listaAnimais.size(); i++)   {
            Animal a = listaAnimais.get(i);

            if (a.getNome().equalsIgnoreCase(nome)) {
                listaAnimais.remove(i);
                System.out.println("Animal removido" + nome);
                return;
            }
        }
        System.out.println("O Animal" + nome + "Nao foi encontrado");

    }
    public void listarAnimais(){
        if (listaAnimais.isEmpty()) {
            System.out.println("O Dono" + nome + "nao possui animais cadastrados no sistema");
            return;
        }
        System.out.println("Animais do Dono" + nome + ":");
        for (Animal a : listaAnimais) {
            System.out.println("- " + a.getNome());
        }


    }
}
