package com.epica4.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epica4.productos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
