package petmanager.service;

import petmanager.model.Cachorro;
import petmanager.model.Gato;
import petmanager.Exception.PetInvalidoException;
import petmanager.model.Animal; // Import Animal se for necessário

import java.util.List; // Import List se for necessário

public class CadastroService {

    // Método que cria Cachorro (7 argumentos)
    public static Cachorro criarCachorro(
            String nome,
            int idade,
            String raca,
            boolean vacinado,
            boolean castrado,      // <-- NOVO
            String corPelo,        // <-- NOVO
            String observacoes
    ) throws PetInvalidoException {

        // Você pode adicionar a validação de raça que estava antes
        if (raca == null || raca.trim().isEmpty()) {
            throw new PetInvalidoException("A raça não pode ser vazia.");
        }

        // Passa 7 argumentos para o construtor do Cachorro
        return new Cachorro(nome, idade, raca, vacinado, castrado, corPelo, observacoes);
    }

    // Método que cria Gato (6 argumentos)
    public static Gato criarGato(
            String nome,
            int idade,
            String corPelo,
            boolean castrado,
            boolean vacinado,      // <-- NOVO
            String observacoes
    ) throws PetInvalidoException {

        // Validações específicas para Gato (se houver)

        // Passa 6 argumentos para o construtor do Gato
        return new Gato(nome, idade, corPelo, castrado, vacinado, observacoes);
    }
}