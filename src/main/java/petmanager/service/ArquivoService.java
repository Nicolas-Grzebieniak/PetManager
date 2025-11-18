package petmanager.service;

import petmanager.model.Animal;
import petmanager.model.Cachorro;
import petmanager.model.Gato;

import java.io.*;
import java.util.ArrayList;

public class ArquivoService {

    private static final String CAMINHO = "animais.txt";

    // ---------------------------------------------------------
    // SALVAR LISTA COMPLETA
    // ---------------------------------------------------------
    public static void salvarAnimais(ArrayList<Animal> lista) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO))) {
            for (Animal a : lista) {
                bw.write(serializar(a));
                bw.newLine();
            }
        }
    }

    // ---------------------------------------------------------
    // CARREGAR LISTA COMPLETA
    // ---------------------------------------------------------
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

    // ---------------------------------------------------------
    // Serialização -> transforma objeto em String
    // ---------------------------------------------------------
    private static String serializar(Animal a) {

        // CACHORRO
        if (a instanceof Cachorro c) {
            return "CACHORRO;" +
                    c.getNome() + ";" +
                    c.getIdade() + ";" +
                    c.getRaca() + ";" +
                    c.isVacinado() + ";" +
                    c.getObservacoes();
        }

        // GATO
        if (a instanceof Gato g) {
            return "GATO;" +
                    g.getNome() + ";" +
                    g.getIdade() + ";" +
                    g.getCorPelo() + ";" +
                    g.isCastrado() + ";" +
                    g.getObservacoes();
        }

        return null;
    }

    // ---------------------------------------------------------
    // Desserialização -> transforma String em objeto
    // ---------------------------------------------------------
    private static Animal deserializar(String linha) {

        String[] p = linha.split(";", 6); // <-- permite observações com ";"
        String tipo = p[0];
        String nome = p[1];
        int idade = Integer.parseInt(p[2]);

        if (tipo.equals("CACHORRO")) {
            String raca = p[3];
            boolean vacinado = Boolean.parseBoolean(p[4]);
            String obs = p.length >= 6 ? p[5] : "";
            return new Cachorro(nome, idade, raca, vacinado, obs);
        }

        if (tipo.equals("GATO")) {
            String corPelo = p[3];
            boolean castrado = Boolean.parseBoolean(p[4]);
            String obs = p.length >= 6 ? p[5] : "";
            return new Gato(nome, idade, corPelo, castrado, obs);
        }

        return null;
    }
}
