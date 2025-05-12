package teste;

//Veiculo.java - Classe Abstrata
public abstract class abs {
 protected String modelo;

 // Método concreto (com implementação)
 public void ligar() {
     System.out.println("Veículo ligado.");
 }

 // Método abstrato (sem implementação)
 public abstract void dirigir();
}
