# SpeedFastApp

Proyecto desarrollado para la actividad formativa de la semana 1 de la asignatura Desarrollo Orientado a Objetos II.

## Descripción

SpeedFastApp representa un sistema de asignación de repartidores para una empresa de reparto a domicilio. El sistema administra tres tipos de pedidos:

- Pedidos de comida.
- Pedidos de encomiendas.
- Pedidos de compra express.

Cada tipo de pedido utiliza una lógica diferente para asignar a su repartidor.

## Conceptos aplicados

- Encapsulamiento de atributos.
- Herencia entre clases.
- Sobreescritura de métodos.
- Sobrecarga de métodos.
- Polimorfismo mediante referencias de tipo `Pedido`.

## Estructura del proyecto

```text
src
├── app
│   └── Main.java
└── model
    ├── Pedido.java
    ├── PedidoComida.java
    ├── PedidoEncomienda.java
    └── PedidoExpress.java
```

## Funcionamiento

La clase `Pedido` contiene los atributos y métodos generales del sistema. Las clases `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` heredan de ella y sobrescriben el método `asignarRepartidor()`.

También se utiliza la versión sobrecargada:

```java
asignarRepartidor(String nombreRepartidor)
```

Esta versión recibe el nombre del repartidor y muestra las validaciones correspondientes a cada tipo de pedido.

## Ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que esté configurado un JDK compatible.
3. Ejecutar la clase `Main`, ubicada en `src/app`.
4. Revisar en consola la asignación de los tres pedidos.

## Tecnologías utilizadas

- Java.
- IntelliJ IDEA.
- Git y GitHub.