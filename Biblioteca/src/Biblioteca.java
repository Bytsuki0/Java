import java.util.ArrayList;

public class Biblioteca {
    
    ArrayList<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(String titulo) {
        livros.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));
    }

    public Livro procurarLivro(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null; 
    }

    public void listarLivros() {
        for (Livro l : livros) {
            l.printlivro();
        }
    }
}
