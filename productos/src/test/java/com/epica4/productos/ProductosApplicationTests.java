package com.epica4.productos;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epica4.productos.controller.ProductoController;
import com.epica4.productos.model.Producto;
import com.epica4.productos.repository.ProductoRepository;

@SpringBootTest
class ProductosApplicationTests {

	@Autowired
	private ProductoController productoController;

	@Autowired
	private ProductoRepository productoRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void listarDevuelveLosProductosRegistrados() {
		productoRepository.deleteAll();
		Producto producto = new Producto(
				"Teclado",
				"Teclado mecánico",
				"Accesorios",
				new BigDecimal("850.00"));
		productoRepository.save(producto);

		List<Producto> productos = productoController.listar();

		assertThat(productos).hasSize(1);
		assertThat(productos.get(0).getNombre()).isEqualTo("Teclado");
	}
}
