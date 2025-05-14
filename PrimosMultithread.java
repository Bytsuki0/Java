public class PrimosMultithread {

    public static int n = 1000000;
    public static int numThreads = 1;
    public static int quantidade_primos = 0;

    // Objeto para sincronização
    public static final Object lock = new Object();

    public static void main(String[] args) {

        if (args.length >= 1) {
            n = Integer.parseInt(args[0]); // valor de n
        }
        if (args.length >= 2) {
            numThreads = Integer.parseInt(args[1]); // número de threads
        }

        long startTime = System.currentTimeMillis();
        calcularQuantidadePrimosParalelo(n, numThreads);
        long endTime = System.currentTimeMillis();

        System.out.println("Entre 1 e " + n + " foram encontrados " + quantidade_primos + " numeros primos");

        double duration = (endTime - startTime) / 1000.0;
        System.out.println("Tempo de execucao: " + duration + " segundos");
    }

    public static void calcularQuantidadePrimosParalelo(int n, int numThreads) {
        Thread[] threads = new Thread[numThreads];
        int intervalo = n / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int inicio = i * intervalo + 1;
            int fim = (i == numThreads - 1) ? n : (i + 1) * intervalo;
            threads[i] = new Thread(new TarefaPrimo(inicio, fim));
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TarefaPrimo implements Runnable {
        private int inicio, fim;

        public TarefaPrimo(int inicio, int fim) {
            this.inicio = inicio;
            this.fim = fim;
        }

        @Override
        public void run() {
            int localCount = 0;
            for (int i = inicio; i <= fim; i++) {
                if (ehPrimo(i)) {
                    localCount++;
                }
            }

            // Atualiza variável compartilhada de forma segura
            synchronized (lock) {
                quantidade_primos += localCount;
            }
        }

        private boolean ehPrimo(int numero) {
            if (numero < 2) return false;
            for (int j = 2; j < numero; j++) {
                if (numero % j == 0)
                    return false;
            }
            return true;
        }
    }
}
