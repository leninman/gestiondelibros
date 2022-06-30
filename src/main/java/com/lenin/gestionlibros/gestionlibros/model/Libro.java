package com.lenin.gestionlibros.gestionlibros.model;






import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    @NotEmpty
    private String isbn;

    @NotEmpty
    private String titulo;
    @NotEmpty
    private String autor;
    @NotEmpty
    private Integer numPaginas;
    @NotEmpty
    private String editorial;

    public Libro() {
    }

    public Libro(Long idLibro, String isbn, String titulo, String autor, Integer numPaginas, String editorial) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.editorial = editorial;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
