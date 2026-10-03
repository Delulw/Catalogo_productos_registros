package com.epica4.productos.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 120, message = "El nombre no puede superar 120 caracteres")
	@Column(nullable = false, length = 120)
	private String nombre;

	@NotBlank(message = "La descripción es obligatoria")
	@Size(max = 1000, message = "La descripción no puede superar 1000 caracteres")
	@Column(nullable = false, length = 1000)
	private String descripcion;

	@NotBlank(message = "La categoría es obligatoria")
	@Size(max = 80, message = "La categoría no puede superar 80 caracteres")
	@Column(nullable = false, length = 80)
	private String categoria;

	@NotNull(message = "El precio base es obligatorio")
	@DecimalMin(value = "0.01", message = "El precio base debe ser mayor que cero")
	@Column(name = "precio_base", nullable = false, precision = 12, scale = 2)
	private BigDecimal precioBase;

	protected Producto() {
	}

	public Producto(String nombre, String descripcion, String categoria, BigDecimal precioBase) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precioBase = precioBase;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}
}
