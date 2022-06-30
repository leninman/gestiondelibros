package com.lenin.gestionlibros.gestionlibros.repo;

import com.lenin.gestionlibros.gestionlibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepo extends JpaRepository<Libro,Long>{
}
