package petmanager.model;



public class Main {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro("Thor", 3,"Doberman", true);
        Gato cat = new Gato("Poro", 2, "Branco", false);

        System.out.println(dog);
        System.out.println("Som: " + dog.emitirSom());

        System.out.println(cat);
        System.out.println("Som: " + cat.emitirSom());
    }
}
