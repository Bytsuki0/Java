import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro a1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        Livro a2 = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);
        Livro a3 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);

        biblioteca.adicionarLivro(a1);
        biblioteca.adicionarLivro(a2);
        biblioteca.adicionarLivro(a3);

        biblioteca.listarLivros();

        biblioteca.removerLivro("O Hobbit");

        biblioteca.listarLivros();

        Livro encontrado = biblioteca.procurarLivro("Harry Potter e a Pedra Filosofal");
        if (encontrado != null) {
            encontrado.printlivro();
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}
