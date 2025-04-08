
public class Gerente extends Funcionario{

	public Gerente(String nome, double salarioBase) {
		super(nome, salarioBase);
	}
	@Override
	public void calcularsalario() {
		salarioBase = salarioBase + salarioBase*0.1;
		System.out.print("Salario: "+ salarioBase);
		
	}
	//
	
}
