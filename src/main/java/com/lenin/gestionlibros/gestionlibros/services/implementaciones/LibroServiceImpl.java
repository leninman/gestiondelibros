package com.lenin.gestionlibros.gestionlibros.services.implementaciones;

import com.lenin.gestionlibros.gestionlibros.model.Libro;
import com.lenin.gestionlibros.gestionlibros.repo.LibroRepo;
import com.lenin.gestionlibros.gestionlibros.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    public LibroRepo librosRepository;

    @Override
    public List<Libro> listarLibros() {
        return librosRepository.findAll();
    }

    @Override
    @Transactional
    public Libro guardarLibro(Libro libro) {
        return librosRepository.save(libro);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Libro> leerLibro(Long idLibro) {
        return librosRepository.findById(idLibro);
    }


    @Override
    @Transactional
    public void eliminarLibro(Long idLibro) {
        librosRepository.deleteById(idLibro);
    }
}
