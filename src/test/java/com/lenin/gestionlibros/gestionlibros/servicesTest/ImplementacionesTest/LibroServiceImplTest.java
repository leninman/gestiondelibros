package com.lenin.gestionlibros.gestionlibros.servicesTest.ImplementacionesTest;

import com.lenin.gestionlibros.gestionlibros.model.Libro;
import com.lenin.gestionlibros.gestionlibros.repo.LibroRepo;
import com.lenin.gestionlibros.gestionlibros.services.LibroService;
import com.lenin.gestionlibros.gestionlibros.services.implementaciones.LibroServiceImpl;
import com.lenin.gestionlibros.gestionlibros.servicesTest.LibroServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LibroServiceImplTest {

    @Autowired
    private LibroRepo libroRepo;

    @Autowired
    private LibroService libroService;


    @Test
    public void guardarLibroTest(){
        Libro libro=new Libro(1L,"123456","Lanzas Coloradas","Arturo Uslar Pietri",300,"Biosfera");


       Libro libroguardado = libroService.guardarLibro(libro);

        assertThat(libroguardado).isNotNull();

    }







}
