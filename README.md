# ApiRestSpringBoot

# API REST Spring Boot - Ejemplo de Usuario y Carrito

Este proyecto es una API REST desarrollada en Spring Boot que gestiona dos entidades: Usuario y Carrito. Utiliza una base de datos H2 en memoria y ofrece varios endpoints para realizar operaciones CRUD en estas entidades.

## Pasos para Ejecutar el Proyecto

Siga estos pasos para descargar, compilar y ejecutar la solución:

1. **Clonar el Repositorio:**
   git clone https://github.com/TU_USUARIO/TU_REPO.git
   cd TU_REPO

 2. **Compilar y Ejecutar el Proyecto:**
  Puede compilar y ejecutar el proyecto utilizando Maven y Spring Boot desde la línea de comandos o desde su IDE. Asegúrese de tener Java y Maven instalados en su sistema.
  mvn spring-boot:run

  3. **Acceder a la API**:
  La API estará disponible en http://localhost:8080

## Endpoints:

### Crear un Usuario (POST)
- Crea un nuevo usuario con la opción de agregar un carrito.
- URL: /usuarios
- Método: POST
- Ejemplo de JSON de Solicitud:
{
    "nombre": "usuario",
    "edad": 26,
    "activo": true,
    "fechaCreacion": "2023-09-28T10:00:00",
    "carrito": {
        "codigo": "CART001",
        "total": 100.00,
        "fechaCompra": "2023-09-28T10:00:00"
    }
}

### Obtener un Usuario (GET)
- Obtiene un usuario por su ID.
- URL: /usuarios/{id}
- Método: GET

### Actualizar un Usuario (PUT)
- Actualiza la información de un usuario existente por su ID.
- URL: /usuarios/{id}
- Método: PUT
- Ejemplo de JSON de Solicitud:
{
    "nombre": "usuario_actualizado",
    "edad": 27,
    "activo": true,
    "fechaCreacion": "2023-09-27T11:00:00"
}

### Eliminar un Usuario (DELETE)
- Elimina un usuario por su ID.
- URL: /usuarios/{id}
- Método: DELETE

### Obtener todos los Usuarios (GET)
- Obtiene la lista de todos los usuarios.
- URL: /usuarios/todos
- Método: GET


### Obtener un Carrito por su ID (GET)
- Obtiene un carrito por su ID.
- URL: /carritos/{idCarrito}
- Método: GET

### Actualizar un Carrito (PUT)
- Actualiza la información de un carrito existente por su ID.
- URL: /carritos/{idCarrito}
- Método: PUT
- Ejemplo de JSON de Solicitud:
{
    "codigo": "CART001_actualizado",
    "total": 200.00,
    "fechaCompra": "2023-09-28T11:00:00"
}

### Obtener el Carrito de un Usuario (GET)
- Obtiene el carrito de compras de un usuario por su ID.
- URL: /carritos/usuario/{idUsuario}
- Método: GET

### Obtener todos los Carritos (GET)
- Obtiene una lista de todos los carritos.
- URL: /carritos/todoscarritos
- Método: GET
# UnitTestJava
