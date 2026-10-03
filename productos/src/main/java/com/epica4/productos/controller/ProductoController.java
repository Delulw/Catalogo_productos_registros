package com.epica4.productos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epica4.productos.model.Producto;
import com.epica4.productos.repository.ProductoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	private final ProductoRepository productoRepository;

	public ProductoController(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@PostMapping
	public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto producto) {
		Producto productoGuardado = productoRepository.save(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
	}
}
