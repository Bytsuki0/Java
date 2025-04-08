
public class Main {

	public static void main(String[] args) {
		Funcionario a1 = new Funcionario("Paulo", 2500);
		Funcionario a2 = new Gerente("Ana", 2500);
		Funcionario a3 = new Operador("Gustavo", 2500);
		
		a1.calcularsalario();
		a1.mostrarNome();
		
		a2.calcularsalario();
		a2.mostrarNome();
		
		a3.calcularsalario();
		a3.mostrarNome();
		

	}

}
