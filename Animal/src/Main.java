// Main.java - Classe principal com o método main
public class Main {

    public static void main(String[] args) {
        // Criando objetos de Cachorro e Gato
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();

        // Chamando o método emitirSom() de cada classe
        cachorro.emitirSom();  // "O cachorro late: Au Au"
        gato.emitirSom();      // "O gato mia: Miau"
    }
}