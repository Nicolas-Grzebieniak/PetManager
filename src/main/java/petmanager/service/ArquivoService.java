package petmanager.service;

import petmanager.model.Animal;
import petmanager.model.Cachorro;
import petmanager.model.Gato;

import java.io.*;
import java.util.ArrayList;

public class ArquivoService {

    private static final String CAMINHO = "animais.txt";

    // SALVAR LISTA COMPLETA
    public static void salvarAnimais(ArrayList<Animal> lista) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO))) {
            for (Animal a : lista) {
                bw.write(serializar(a));
                bw.newLine();
            }
        }
    }

    // CARREGAR LISTA COMPLETA
    public static ArrayList<Animal> carregarAnimais() throws IOException {
        ArrayList<Animal> lista = new ArrayList<>();

        File file = new File(CAMINHO);
        if (!file.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Animal a = deserializar(linha);
                if (a != null) lista.add(a);
            }
        }
        return lista;
    }

    // Serialização -> transforma objeto em String
    private static String serializar(Animal a) {

        // CACHORRO (Agora com Castrado e CorPelo)
        if (a instanceof Cachorro c) { //<---- Onde está o polimorfismo!!!
            return "CACHORRO;" +
                    c.getNome() + ";" +
                    c.getIdade() + ";" +
                    c.getRaca() + ";" +
                    c.isVacinado() + ";" +
                    c.isCastrado() + ";" +
                    c.getCorPelo() + ";" +
                    c.getObservacoes();
        }

        // GATO (Agora com Vacinado)
        if (a instanceof Gato g) {
            return "GATO;" +
                    g.getNome() + ";" +
                    g.getIdade() + ";" +
                    g.getCorPelo() + ";" +
                    g.isCastrado() + ";" +
                    g.isVacinado() + ";" +
                    g.getObservacoes();
        }
        return null;
    }

    // Desserialização -> transforma String em objeto
    private static Animal deserializar(String linha) {

        String[] p = linha.split(";"); // Removemos o limite 6

        if (p.length < 5) return null; // Linha muito curta

        String tipo = p[0];
        String nome = p[1];
        int idade = Integer.parseInt(p[2]);

        if (tipo.equals("CACHORRO")) {
            if (p.length < 7) return null; // Linha incompleta (menos de 7 atributos específicos)

            String raca = p[3];
            boolean vacinado = Boolean.parseBoolean(p[4]);
            boolean castrado = Boolean.parseBoolean(p[5]);
            String corPelo = p[6];
            String obs = p.length > 7 ? p[7] : "";

            // ATENÇÃO: Construtor deve bater com 7 argumentos
            return new Cachorro(nome, idade, raca, vacinado, corPelo);
        }

        if (tipo.equals("GATO")) {
            if (p.length < 6) return null; // Linha incompleta (menos de 6 atributos específicos)

            String corPelo = p[3];
            boolean castrado = Boolean.parseBoolean(p[4]);
            boolean vacinado = Boolean.parseBoolean(p[5]);
            String obs = p.length > 6 ? p[6] : "";

            // ATENÇÃO: Construtor deve bater com 6 argumentos
            return new Gato(nome, idade, corPelo, castrado, vacinado, obs);
        }
        return null;
    }
}