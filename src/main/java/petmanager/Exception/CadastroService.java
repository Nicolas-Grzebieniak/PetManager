package petmanager.Exception;

import petmanager.model.Cachorro;
import petmanager.model.Gato;

//Caiu em desuso!!!!


public class CadastroService {

    // Validação básica para qualquer animal
    public static void validarAnimal(String nome, int idade) throws PetInvalidoException {
        if (nome == null || nome.isBlank()) {
            throw new PetInvalidoException("O nome não pode ser vazio.");
        }

        if (idade < 0) {
            throw new PetInvalidoException("A idade não pode ser negativa.");
        }
    }

    // Criar Cachorro
    public static Cachorro criarCachorro(
            String nome,
            int idade,
            String raca,
            boolean vacinado,
            String observacoes
    ) throws PetInvalidoException {

        validarAnimal(nome, idade);

        if (raca == null || raca.isBlank()) {
            throw new PetInvalidoException("A raça não pode ser vazia.");
        }

        // Observações pode ser vazio, então não valida

        return new Cachorro(nome, idade, raca, vacinado, observacoes);
    }

    // Criar Gato
    public static Gato criarGato(
            String nome,
            int idade,
            String corPelo,
            boolean castrado,
            String observacoes
    ) throws PetInvalidoException {

        validarAnimal(nome, idade);

        if (corPelo == null || corPelo.isBlank()) {
            throw new PetInvalidoException("A cor do pelo não pode ser vazia.");
        }

        return new Gato(nome, idade, corPelo, castrado, observacoes);
    }
}


