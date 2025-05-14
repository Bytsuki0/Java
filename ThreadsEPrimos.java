public class ThreadsEPrimos {
    public static int n = 100000;
    public static int quantidade_primos = 0;
    public static int threads = 5;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else if (args.length == 2) {
            n = Integer.parseInt(args[0]);
            threads = Integer.parseInt(args[1]);
        }
        long startTime = System.currentTimeMillis();
        calcularQuantidadePrimos(n, threads);
        long endTime = System.currentTimeMillis();
        System.out.println("Entre 1 e " + n + " foram encontrados " + quantidade_primos + " numeros primos");
        double duration = (endTime - startTime) / 1000.0;
        System.out.println("Tempo de execucao: " + duration + " segundos");
    }

    private static void calcularQuantidadePrimos(int n, int threads) {
        Thread[] thread = new Thread[threads];
        int pf, pi;
        int particoes = n / threads;
        for (int i = 0; i < threads; i++) {
            pi = i * particoes + 1;
            if(i == threads){
                pf = n;
            } else {
                pf = (i + 1) * particoes;
            }
            thread[i] = new Thread(new Threads(pi, pf));
            thread[i].start();
        }
        for (int i = 0; i < threads; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Threads implements Runnable {
        private int ini, fim;

        public Threads(int ini, int fim) {
            this.ini = ini;
            this.fim = fim;
        }

        @Override
        public void run() {
            for (int i = ini; i <= fim; i++) {
                if (ehPrimo(i)) {
                    synchronized (lock) {
                        quantidade_primos++;
                    }
                }
            }
        }
    }
    private static boolean ehPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        int limite = (int) Math.sqrt(numero);
        for (int j = 2; j <= limite; j++) {
            if (numero % j == 0) {
                return false;
            }
        }
        return true;
    }
}
