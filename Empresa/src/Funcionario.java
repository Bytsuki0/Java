
public class Funcionario {
	String nome;
	double salarioBase;	
	
	public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }
	
	//
	public void calcularsalario() {
		System.out.print("Salario: "+ salarioBase);
		
	}
	 public void mostrarNome() {
	        System.out.println(" Nome: " + nome);
	    }
	
}

