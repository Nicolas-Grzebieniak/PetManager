package petmanager.model;

import java.util.ArrayList;
import petmanager.service.CadastroService; // <-- CORRIGIDO
import petmanager.Exception.PetInvalidoException;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> pets = new ArrayList<>();

        // Teste de subclasses ------------------------------------------------------------
        // Cachorro AGORA precisa de 7 argumentos
        Cachorro dog = new Cachorro("Thor", 3, "Doberman", true, true, "Marrom e Preto", "Cão de guarda.");

        // Gato AGORA precisa de 6 argumentos
        Gato cat = new Gato("Poro", 2, "Branco", false, true, "Gato dócil, castrado.");

        System.out.println(dog);
        System.out.println("Som: " + dog.emitirSom());

        System.out.println(cat);
        System.out.println("Som: " + cat.emitirSom());

        // Teste de polimorfismo -----------------------------------------------------------

        // Cachorro (7 argumentos)
        pets.add(new Cachorro("Rex", 5, "Golden Retriever", true, false, "Dourado", "Gosta de água."));

        // Gato (6 argumentos)
        pets.add(new Gato("Mimi", 3, "Preto", true, true, "Muito agitada."));

        // Cachorro (7 argumentos)
        pets.add(new Cachorro("Jade", 2, "Poodle", false, false, "Branco", "Precisa de tosa."));

        for (Animal pet : pets) {
            System.out.println(pet);
            System.out.println("Som: " + pet.emitirSom());
            System.out.println("--------------------");
        }

        // Teste de exception -------------------------------------------------------------

        try {
            // Chamada do CadastroService (7 argumentos)
            // Aqui testamos a exceção do nome vazio (primeiro argumento = "")
            Cachorro dog1 = CadastroService.criarCachorro("", 3, "Pug", true, true, "Marrom", "Pug recém-chegado.");

            // CORRIGIDO: Deve imprimir dog1, não dog
            System.out.println("Cachorro criado: " + dog1);

        } catch (PetInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}