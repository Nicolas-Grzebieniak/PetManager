package Exception;
import petmanager.model.Cachorro;
import petmanager.model.Gato;

public class CadastroService {

    public static void validarAnimal(String nome, int idade) throws PetInvalidoException {
        if (nome == null || nome.isBlank()) {
            throw new PetInvalidoException("O nome não pode ser vazio.");
        }

        if (idade < 0) {
            throw new PetInvalidoException("A idade não pode ser negativa.");
        }
    }

    public static Cachorro criarCachorro(String nome, int idade, String raca, boolean vacinado)
            throws PetInvalidoException {

        validarAnimal(nome, idade);

        if (raca == null || raca.isBlank()) {
            throw new PetInvalidoException("A raça não pode ser vazia.");
        }

        return new Cachorro(nome, idade, raca, vacinado);
    }

    public static Gato criarGato(String nome, int idade, String corPelo, boolean castrado)
            throws PetInvalidoException {

        validarAnimal(nome, idade);

        if (corPelo == null || corPelo.isBlank()) {
            throw new PetInvalidoException("A cor do pelo não pode ser vazia.");
        }

        return new Gato(nome, idade, corPelo, castrado);
    }
}

