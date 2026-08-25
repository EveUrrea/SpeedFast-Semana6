# SpeedFastApp - Semana 2

## Desarrollo Orientado a Objetos II

Proyecto desarrollado para la actividad de la Semana 2 de la asignatura Desarrollo Orientado a Objetos II.

En esta actividad se implementa una clase abstracta y una jerarquía de clases para representar distintos tipos de pedidos de la empresa **SpeedFast**.

## Objetivo

Aplicar conceptos de Programación Orientada a Objetos utilizando:

* Clases abstractas.
* Herencia.
* Sobrescritura de métodos.
* Reutilización de código.
* Polimorfismo.
* Métodos y atributos comunes.

## Estructura del proyecto

El proyecto está organizado de la siguiente manera:

```text
src
├── app
│   └── Main.java
│
└── model
    ├── Pedido.java
    ├── PedidoComida.java
    ├── PedidoEncomienda.java
    └── PedidoExpress.java
```

## Clase abstracta Pedido

La clase `Pedido` corresponde a la clase padre de los distintos tipos de pedidos.

Contiene los siguientes atributos comunes:

* `idPedido`
* `direccionEntrega`
* `distanciaKm`

Además, contiene el método:

```java
mostrarResumen()
```

Este método permite mostrar la información básica de cada pedido.

También se declara el método abstracto:

```java
calcularTiempoEntrega()
```

Este método debe ser implementado por cada una de las clases derivadas, ya que el cálculo del tiempo de entrega depende del tipo de pedido.

## Clases derivadas

### PedidoComida

La clase `PedidoComida` hereda de `Pedido`.

El tiempo estimado de entrega se calcula utilizando:

```text
15 minutos base + 2 minutos por cada kilómetro
```

Ejemplo para una distancia de 4 km:

```text
15 + (2 × 4) = 23 minutos
```

### PedidoEncomienda

La clase `PedidoEncomienda` hereda de `Pedido`.

El tiempo estimado de entrega se calcula utilizando:

```text
20 minutos base + 1.5 minutos por cada kilómetro
```

El resultado es ajustado a un número entero.

Ejemplo para una distancia de 6 km:

```text
20 + (1.5 × 6) = 29 minutos
```

### PedidoExpress

La clase `PedidoExpress` hereda de `Pedido`.

Su tiempo base de entrega es:

```text
10 minutos
```

Si la distancia del pedido es mayor a 5 km, se agregan 5 minutos adicionales.

Ejemplo para una distancia de 7 km:

```text
10 + 5 = 15 minutos
```

## Clase Main

La clase `Main` crea un objeto de cada tipo de pedido:

* `PedidoComida`
* `PedidoEncomienda`
* `PedidoExpress`

Para cada objeto se ejecutan los métodos:

```java
mostrarResumen()
calcularTiempoEntrega()
```

De esta manera se muestran los datos de cada pedido junto con su tiempo estimado de entrega.

## Ejemplo de ejecución

```text
=== PEDIDOS SPEEDFAST ===

PedidoComida #001
Dirección: Av. Italia 456
Distancia: 4.0 km
Tiempo estimado de entrega: 23 minutos

PedidoEncomienda #002
Dirección: Av. Independencia 123
Distancia: 6.0 km
Tiempo estimado de entrega: 29 minutos

PedidoExpress #003
Dirección: Av. Apoquindo 1500
Distancia: 7.0 km
Tiempo estimado de entrega: 15 minutos
```

## Tecnologías utilizadas

* Java
* IntelliJ IDEA
* Git
* GitHub

## Ejecución

1. Abrir el proyecto `SpeedFastApp` en IntelliJ IDEA.
2. Verificar que exista un JDK configurado.
3. Ejecutar la clase `Main` ubicada en `src/app`.
4. Revisar los resultados mostrados en la consola.

## Resultado

El proyecto demuestra el uso de una clase abstracta como base para diferentes tipos de pedidos, permitiendo reutilizar atributos y comportamientos comunes y personalizar el cálculo del tiempo de entrega mediante la sobrescritura de métodos.
