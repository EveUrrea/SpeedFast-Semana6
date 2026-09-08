# SpeedFastApp - Semana 4

## Desarrollo Orientado a Objetos II

Proyecto desarrollado para la actividad formativa de la Semana 4 de la asignatura Desarrollo Orientado a Objetos II.

## Objetivo

Implementar programación concurrente en Java para simular el proceso de entrega de pedidos de la empresa SpeedFast.

El sistema permite que varios repartidores realicen entregas de manera simultánea mediante el uso de hilos.

## Estructura del proyecto

El sistema utiliza una clase abstracta `Pedido` y las siguientes subclases:

- `PedidoComida`
- `PedidoEncomienda`
- `PedidoExpress`

También utiliza las interfaces:

- `Despachable`
- `Cancelable`
- `Rastreable`

Para implementar la concurrencia se creó la clase `Repartidor`, la cual implementa la interfaz `Runnable`.

## Programación concurrente

Cada repartidor posee una lista de pedidos asignados.

El método `run()` de la clase `Repartidor` recorre los pedidos y simula el tiempo de cada entrega utilizando `Thread.sleep()` con tiempos aleatorios.

La clase `Main` utiliza `ExecutorService` para ejecutar tres repartidores de manera concurrente.

Cada repartidor tiene asignados dos pedidos, permitiendo observar en consola cómo las entregas se realizan de forma simultánea.

## Manejo de excepciones

Se utiliza `try-catch` para manejar posibles interrupciones durante la ejecución de los hilos.

En caso de producirse una `InterruptedException`, el programa controla la excepción para evitar una finalización inesperada.

## Ejecución

Durante la ejecución se muestran mensajes en consola indicando:

- Nombre del repartidor.
- Tipo de pedido.
- Número del pedido.
- Inicio de la entrega.
- Finalización de cada entrega.
- Finalización de las tareas de cada repartidor.

Al finalizar todos los hilos, el sistema informa que todos los repartidores han terminado sus entregas.

## Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Programación Orientada a Objetos
- Runnable
- Thread
- ExecutorService
- Git y GitHub