package com.lenin.gestionlibros.gestionlibros.controllers;

import com.lenin.gestionlibros.gestionlibros.model.Libro;
import com.lenin.gestionlibros.gestionlibros.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@CrossOrigin({"*"})
@RestController
public class LibroController {

    @Autowired
   private LibroService libroService;

    @GetMapping
    public ResponseEntity<?> listarLibros(){
        return ResponseEntity.ok().body(libroService.listarLibros());
    }


    @GetMapping("/{idLibro}")
    public ResponseEntity<?> leerLibro(@PathVariable Long idLibro){
        Optional<Libro> o = libroService.leerLibro(idLibro);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(o.get());
    }

    @PostMapping
    public ResponseEntity<?> crearLibro(@Valid @RequestBody Libro libro,BindingResult result){
        if(result.hasErrors()) {
            return this.validar(result);
        }


        Libro libroCreado=libroService.guardarLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroCreado);
    }

    @PutMapping("/{idLibro}")
    public ResponseEntity<?> actualizarLibro(@Valid @RequestBody Libro libro,BindingResult result,@PathVariable Long idLibro){

        if(result.hasErrors()) {
            return this.validar(result);
        }

        Optional<Libro> o = libroService.leerLibro(idLibro);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Libro libroDb=o.get();
        libroDb.setIsbn(libro.getIsbn());
        libroDb.setAutor(libro.getAutor());
        libroDb.setTitulo(libro.getTitulo());
        libroDb.setEditorial(libro.getEditorial());
        libroDb.setNumPaginas(libro.getNumPaginas());

        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.guardarLibro(libroDb));
    }

    @DeleteMapping("/{idLibro}")
    public ResponseEntity<?> eliminarLibro(@PathVariable Long idLibro){
        libroService.eliminarLibro(idLibro);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<?> validar(BindingResult result){
        Map<String,Object> errores=new HashMap<>();

        result.getFieldErrors().forEach(err->{
            errores.put(err.getField()," El campo " + err.getField() + " " + err.getDefaultMessage());

        });

        return ResponseEntity.badRequest().body(errores);
    }



}
