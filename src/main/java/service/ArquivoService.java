package service;

import petmanager.model.Animal;
import petmanager.model.Cachorro;
import petmanager.model.Dono;

import java.io.*;
import java.util.ArrayList;

public class ArquivoService {

    private final String caminho = "donos.txt";


    // CREATE

    public void salvarDono(Dono dono) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            writer.write(serializarDono(dono));
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar dono", e);
        }
    }


    // READ

    public ArrayList<Dono> lerDonos() {
        ArrayList<Dono> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                lista.add(deserializarDono(linha));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler donos", e);
        }

        return lista;
    }


    // UPDATE (reescreve o arquivo)

    public void atualizarDonos(ArrayList<Dono> donos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (Dono d : donos) {
                writer.write(serializarDono(d));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao atualizar donos", e);
        }
    }


    // DELETE

    public void deletarDono(String nomeDono) {
        ArrayList<Dono> donos = lerDonos();
        donos.removeIf(d -> d.getNome().equalsIgnoreCase(nomeDono));
        atualizarDonos(donos);
    }


    // Objeto → String

    private String serializarDono(Dono dono) {
        StringBuilder sb = new StringBuilder();

        sb.append(dono.getNome()).append(";")
                .append(dono.getTelefone()).append(";");

        for (Animal a : dono.getListaAnimais()) {

            if (a instanceof Cachorro c) {
                sb.append("Cachorro").append(",")
                        .append(c.getNome()).append(",")
                        .append(c.getIdade()).append(",")
                        .append(c.getPeso()).append(",")
                        .append(c.getRaca()).append(",")
                        .append(c.isVacinado())
                        .append("|");
            }
        }

        return sb.toString();
    }

    // String → Objeto

    private Dono deserializarDono(String linha) {

        String[] partes = linha.split(";");

        String nome = partes[0];
        String telefone = partes[1];
        Dono dono = new Dono(nome, telefone);

        if (partes.length == 3) {
            String[] animais = partes[2].split("\\|");

            for (String info : animais) {

                if (info.isBlank()) continue;

                String[] dados = info.split(",");

                String tipo = dados[0];

                if (tipo.equalsIgnoreCase("Cachorro")) {

                    String nomeAnimal = dados[1];
                    int idade = Integer.parseInt(dados[2]);
                    double peso = Double.parseDouble(dados[3]);
                    String raca = dados[4];
                    boolean vacinado = Boolean.parseBoolean(dados[5]);

                    Cachorro c = new Cachorro(nomeAnimal, idade, raca, vacinado);
                    c.setPeso(peso);

                    dono.adicionarAnimal(c);
                }
            }
        }

        return dono;
    }
}
