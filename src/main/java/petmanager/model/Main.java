package petmanager.model;
import java.util.ArrayList;
import Exception.CadastroService;
import Exception.PetInvalidoException;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> pets = new ArrayList<>();



        //Teste de subclasses ------------------------------------------------------------

        Cachorro dog = new Cachorro("Thor", 3,"Doberman", true);
        Gato cat = new Gato("Poro", 2, "Branco", false);

        System.out.println(dog);
        System.out.println("Som: " + dog.emitirSom());

        System.out.println(cat);
        System.out.println("Som: " + cat.emitirSom());

        //Teste de polimorfismo -----------------------------------------------------------

        pets.add(new Cachorro("Rex", 5, "Golden Retriever", true));
        pets.add(new Gato("Mimi", 3, "Preto", true));
        pets.add(new Cachorro("Jade", 2, "Poodle", false));

        for (Animal pet : pets) {
            System.out.println(pet);
            System.out.println("Som: " + pet.emitirSom());
            System.out.println("--------------------");
        }

        //Teste de exception -------------------------------------------------------------

        try {
            Cachorro dog1 = CadastroService.criarCachorro("", 3, "Pug", true);
            System.out.println("Cachorro criado: " + dog);

        } catch (PetInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
