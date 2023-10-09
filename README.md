# UnitTestJava

Este proyecto es una aplicación desarrollada en Spring Boot que proporciona una API para administrar usuarios y carritos de compras. Este documento se enfoca en la documentación de las pruebas unitarias realizadas en el proyecto.

## Estructura del proyecto

Este proyecto está organizado de la siguiente manera:
- src/main/java: Contiene el código fuente principal de la aplicación.
- src/test/java: Contiene las clases de prueba unitaria.
- pom.xml: Archivo de configuración de Maven que define las dependencias y plugins utilizados en el proyecto.

## Pruebas unitarias

Los endpoints de la API se prueban en los controladores que se encuentran en la carpeta src/test/java bajo el package com.h2.h2api, utilizando el framework de pruebas de Spring Boot y la biblioteca Mockito para simular servicios y comportamientos.

## Ejecución de pruebas

Para ejecutar las pruebas unitarias, puedes utilizar el comando mvn test en la raíz del proyecto. Asegúrate de tener Maven instalado y configurado en tu entorno.

