package com.lenin.gestionlibros.gestionlibros.servicesTest;


import com.lenin.gestionlibros.gestionlibros.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroServiceTest {

    public List<Libro> listarLibros();

    public Libro guardarLibro(Libro libro);

    public Optional<Libro> leerLibro(Long idLibro);


    public void eliminarLibro(Long idLibro);
}
