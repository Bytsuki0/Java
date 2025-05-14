public class Primos  {

    public static int n = 1000;
    public static int quantidade_primos = 0;

    public static void main(String[] args) {    

        if(args.length == 1) {
            n = Integer.parseInt(args[0]);  // permite passar o valor de n na linha de comando: java Primos 1000 , por exemplo
        }
        
        long startTime = System.currentTimeMillis();
        calcularQuantidadePrimos(n);
        long endTime = System.currentTimeMillis();

        System.out.println("Entre 1 e " + n + " foram encontrados " + quantidade_primos + " números primos");
        
        double duration = (endTime - startTime)/1000.0;  // calcula o tempo de execucao em segundos
        System.out.println("Tempo de execução: " + duration + " segundos");
    }

    // calcula a quantidade de numeros primos entre 1 e n
    private static void calcularQuantidadePrimos(int n) {
        int contador = 0;
        for (int i = 1; i <= n; i++) {
            if( ehPrimo(i) )
                contador++;
        }
        quantidade_primos = contador;
    }
    
    // determina se um numero eh primo ou nao
    private static boolean ehPrimo(int numero) {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;   
        }
        //System.out.println("É primo: " + numero);
        return true;
    }

   

}