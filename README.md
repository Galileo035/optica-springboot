# Sistema de Compra y Venta para Óptica

---

## 1. Descripción general del proyecto

Este proyecto es un sistema de compra y venta de una óptica en el que el usuario elige y personaliza su producto con diversas opciones. Así mismo, el sistema calcula la cotización final, detecta si existe alguna promoción o descuento aplicable y, en caso de realizarse la operación, genera el ticket correspondiente.

---

## 2. Equipo Los Jerrys

- **Hernández González Erick**
- **Hernández Gutierrez Eduardo Nicolas**
- **Pérez Espinosa Gael Alejandro**

---

## 3. Tabla de requerimientos (primeros 5 requerimientos a cubrir)

| ID | Requerimiento | Descripción |
|----|---------------|-------------|
| **RF-01** | Selección de armazón | El sistema debe permitir al usuario visualizar y elegir entre un catálogo de al menos 3 opciones diferentes de tipos de armazón para sus lentes. |
| **RF-02** | Selección de graduación | El sistema debe ofrecer al usuario un menú con al menos 3 opciones de graduación óptica para adaptar los lentes a sus necesidades visuales. |
| **RF-03** | Selección de accesorios | El sistema debe permitir al usuario seleccionar y añadir accesorios complementarios opcionales para los lentes dentro de su compra. |
| **RF-04** | Cálculo de cotización | El sistema debe calcular de forma dinámica el subtotal de la compra sumando los costos individuales del armazón, la graduación y los accesorios seleccionados. |
| **RF-05** | Aplicación de descuentos y promociones | El sistema debe identificar y aplicar automáticamente el cálculo de promociones de temporada o descuentos especiales sobre el costo total de la compra. |

---

## 4. Lista de funcionalidades con paquetes de Spring Boot

### 4.1 Autenticación y seguridad (usuarios y roles)

- **Funcionalidad:** Permitir que los clientes inicien sesión para guardar su historial de compras y graduaciones, o que exista un rol de "Administrador" para gestionar los catálogos (armazones, graduaciones, accesorios y promociones).
- **Paquete de Spring Boot:** Spring Security (`spring-boot-starter-security`).
- **Qué aporta:** Se encarga de la codificación de contraseñas, el control de sesiones, la protección contra ataques comunes y la restricción de rutas según el rol del usuario (Cliente vs. Administrador).

### 4.2 Conexión a base de datos y persistencia

- **Funcionalidad:** Guardar de forma permanente los productos (armazones, accesorios), los precios, las promociones vigentes y las órdenes de compra realizadas por los clientes.
- **Paquete de Spring Boot:** Spring Data JPA (`spring-boot-starter-data-jpa`) junto con un driver como el de MySQL o PostgreSQL.
- **Qué aporta:** Evita escribir código SQL complejo a mano. Convierte las tablas de la base de datos en clases de Java (entidades) de forma automática y maneja las consultas con facilidad.

### 4.3 Gestión de registros y trazabilidad (logs)

- **Funcionalidad:** Registrar en segundo plano las acciones importantes del sistema (cuándo un cliente hizo una cotización, si hubo un error al calcular un descuento, o cuándo un administrador modificó un precio).
- **Paquete de Spring Boot:** Spring Boot Starter Logging (viene integrado por defecto, utilizando SLF4J y Logback).
- **Qué aporta:** Genera reportes en consola o en archivos de texto con marcas de tiempo y niveles de severidad (INFO, WARN, ERROR) para saber qué está pasando en la aplicación mientras se ejecuta.

### 4.4 Documentación de la API (para pruebas y catálogos)

- **Funcionalidad:** Si el sistema funciona mediante servicios o una API (por ejemplo, para que una página web o app móvil consulte los armazones y calcule los precios), es necesario documentarla para saber cómo usarla.
- **Paquete de Spring Boot:** SpringDoc OpenAPI (`springdoc-openapi-starter-webmvc-ui`).
- **Qué aporta:** Genera automáticamente una interfaz visual interactiva (Swagger UI) en el navegador donde se pueden ver todos los endpoints disponibles para consultar los armazones y graduaciones, y probar las compras sin necesidad de herramientas externas.

### 4.5 Validación de datos de entrada

- **Funcionalidad:** Asegurar que cuando el usuario elija una opción, los datos sean correctos (por ejemplo, que la cantidad de accesorios no sea negativa, que el ID del armazón exista y que los campos obligatorios no vengan vacíos).
- **Paquete de Spring Boot:** Spring Boot Starter Validation (`spring-boot-starter-validation`).
- **Qué aporta:** Permite usar anotaciones sencillas (como `@NotNull`, `@Min`, `@Size`) en las clases para validar automáticamente la información antes de procesar la compra o la cotización.
