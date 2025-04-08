
public class Operador extends Funcionario{

	public Operador(String nome, double salarioBase) {
		super(nome, salarioBase);
	}
	@Override
	public void calcularsalario() {
		salarioBase = salarioBase + 500;
		System.out.print("Salario: "+ salarioBase);
		
	}
	
}
