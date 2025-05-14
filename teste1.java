public class teste1 {

    // Parâmetros padrão — podem ser sobrescritos pela linha de comando
    private static int n = 1000000;
    private static int numThreads = 1;

    public static void main(String[] args) throws InterruptedException {
        // Lê parâmetros se fornecidos
        if (args.length >= 1) {
            n = Integer.parseInt(args[0]);
        }
        if (args.length >= 2) {
            numThreads = Integer.parseInt(args[1]);
        }

        Thread[] threads = new Thread[numThreads];
        // Cada thread armazena o seu resultado neste vetor
        final int[] resultados = new int[numThreads];

        int chunkSize = n / numThreads;
        long t0 = System.nanoTime();

        for (int i = 0; i < numThreads; i++) {
            final int idx = i;
            final int start = i * chunkSize + 1;
            final int end = (i == numThreads - 1) ? n : (i + 1) * chunkSize;

            threads[i] = new Thread(() -> {
                int countLocal = 0;
                for (int x = start; x <= end; x++) {
                    if (ehPrimo(x)) {
                        countLocal++;
                    }
                }
                resultados[idx] = countLocal;
            }, "Thread-" + (i + 1));
            threads[i].start();
        }

        // Aguarda todas terminarem
        for (Thread t : threads) {
            t.join();
        }

        long t1 = System.nanoTime();

        // Soma os resultados
        int totalPrimos = 0;
        for (int c : resultados) {
            totalPrimos += c;
        }

        System.out.printf("Entre 1 e %d (%d threads) foram encontrados %d primos%n",
                          n, numThreads, totalPrimos);
        System.out.printf("Tempo de execução: %.3f s%n", (t1 - t0) / 1e9);
    }

    // Mesma rotina não-otimizada de verificação de primo
    private static boolean ehPrimo(int numero) {
        if (numero < 2) return false;
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0) return false;
        }
        return true;
    }
}
