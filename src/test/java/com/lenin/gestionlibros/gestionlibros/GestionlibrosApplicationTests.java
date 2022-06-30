package com.lenin.gestionlibros.gestionlibros;

import com.lenin.gestionlibros.gestionlibros.controllers.LibroController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class GestionlibrosApplicationTests {

	@Autowired
	private LibroController libroController;
	@Test
	void contextLoads() {
		assertThat(libroController).isNotNull();
	}

}
