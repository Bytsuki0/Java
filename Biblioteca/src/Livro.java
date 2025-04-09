public class Livro {
    String titulo;
    String autor;
    int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

   
    public void printlivro() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", Ano de Publicação: " + anoPublicacao);
    }
    public String getTitulo() {
        return titulo;
    }
}
