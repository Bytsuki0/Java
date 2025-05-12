// Cachorro.java - Subclasse que implementa a classe abstrata Animal
public class Cachorro extends Animal {

    // Implementação do método abstrato
    @Override
    public void emitirSom() {
        System.out.println("O cachorro late: Au Au");
    }
}