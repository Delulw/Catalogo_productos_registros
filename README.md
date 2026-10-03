# Catálogo de productos

Este proyecto desarrolla una aplicación para registrar productos y consultar el
catálogo disponible. Se realizó con Spring Boot y utiliza una base de datos H2
para guardar los productos durante la ejecución.

## Desarrollo del proyecto

Primero se definieron los datos que necesita cada producto: nombre, descripción,
categoría y precio base. Después se organizó el código para separar la
información del producto, el acceso a los datos y las solicitudes que recibe la
aplicación. Esta separación facilita entender y mantener cada parte.

## Función de los archivos

- **`ProductosApplication.java`** inicia la aplicación Spring Boot. Es el punto
  de entrada para que el resto de los componentes puedan funcionar.
- **`model/Producto.java`** representa un producto y contiene sus datos. También
  establece qué información es obligatoria y que el precio debe ser mayor que
  cero.
- **`repository/ProductoRepository.java`** se encarga de guardar y recuperar
  productos. Spring Data JPA conecta este componente con la base de datos.
- **`controller/ProductoController.java`** recibe las solicitudes relacionadas
  con los productos. Permite registrar un producto y consultar la lista
  disponible.
- **`application.properties`** reúne la configuración de la aplicación y de la
  base de datos H2.
- **`pom.xml`** describe las dependencias y herramientas que necesita el
  proyecto, como Spring Boot, JPA, H2 y la validación de datos.
- **`ProductosApplicationTests.java`** contiene pruebas que comprueban que la
  aplicación inicia y que los productos guardados se pueden consultar.

## Cómo trabajan juntas las partes

Cuando se registra un producto, el controlador recibe sus datos y comprueba que
sean válidos. Luego utiliza el repositorio para guardarlos en H2. Cuando se
consulta el catálogo, el controlador pide al repositorio los productos
guardados y devuelve la lista. Si todavía no se ha registrado ninguno, devuelve
una lista vacía.

De esta manera, el proyecto cubre dos necesidades: mantener los productos del
catálogo y permitir que los clientes consulten cuáles están disponibles.
