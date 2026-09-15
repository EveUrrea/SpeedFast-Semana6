# SpeedFast - Semana 5

## Coordinación de entregas en un entorno concurrente

Este proyecto simula el proceso de entrega de pedidos de la empresa SpeedFast utilizando programación concurrente en Java.

El sistema permite que varios repartidores trabajen de manera simultánea sobre una zona de carga compartida, utilizando mecanismos de sincronización para evitar que un mismo pedido sea retirado por más de un repartidor.

## Estructura del proyecto

El proyecto se encuentra organizado en los siguientes paquetes:

### app

Contiene la clase principal encargada de iniciar la aplicación.

- `Main.java`: crea la zona de carga, agrega los pedidos, crea los repartidores e inicia los hilos de ejecución.

### model

Contiene las clases relacionadas con la lógica del sistema.

- `Pedido.java`: representa cada pedido con su identificador, dirección de entrega y estado.
- `EstadoPedido.java`: enum que contiene los estados `PENDIENTE`, `EN_REPARTO` y `ENTREGADO`.
- `ZonaDeCarga.java`: representa el recurso compartido donde se almacenan los pedidos.
- `Repartidor.java`: implementa `Runnable` y contiene la lógica ejecutada por cada repartidor.

## Programación concurrente

Para simular el trabajo simultáneo de los repartidores se utilizan objetos `Thread`.

Se crean tres repartidores:

- Juan
- Camila
- Pedro

Cada repartidor ejecuta su trabajo de manera independiente y retira pedidos desde la misma zona de carga.

## Sincronización

La clase `ZonaDeCarga` utiliza métodos `synchronized` para controlar el acceso al recurso compartido.

El método:

```java
public synchronized Pedido retirarPedido()
```

permite que solamente un hilo pueda retirar un pedido de la zona de carga a la vez.

De esta manera se evita que dos repartidores retiren el mismo pedido y se reducen las condiciones de carrera durante la ejecución concurrente.

## Estados de los pedidos

Cada pedido puede tener uno de los siguientes estados:

- `PENDIENTE`: estado inicial del pedido.
- `EN_REPARTO`: el pedido fue retirado por un repartidor y se encuentra en proceso de entrega.
- `ENTREGADO`: la entrega fue finalizada correctamente.

## Simulación de las entregas

Cada repartidor realiza el siguiente proceso:

1. Retira un pedido desde la zona de carga.
2. Cambia su estado a `EN_REPARTO`.
3. Muestra en consola el pedido que está procesando.
4. Simula el tiempo de entrega utilizando `Thread.sleep()`.
5. Cambia el estado del pedido a `ENTREGADO`.
6. Continúa retirando pedidos hasta que no queden pedidos disponibles.

## Finalización de los hilos

La clase `Main` utiliza el método `join()` para esperar que los tres hilos terminen su ejecución antes de finalizar el programa.

Una vez completadas todas las entregas, se muestra el mensaje:

```text
Todos los pedidos han sido entregados correctamente
```

## Manejo de excepciones

Las posibles interrupciones producidas durante `Thread.sleep()` y `join()` son controladas mediante `try-catch`.

En caso de una `InterruptedException`, se restaura el estado de interrupción del hilo utilizando:

```java
Thread.currentThread().interrupt();
```

Esto permite controlar adecuadamente una interrupción durante la ejecución.

## Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Programación Orientada a Objetos
- Runnable
- Thread
- synchronized
- Git
- GitHub

## Resultado

El sistema permite ejecutar múltiples repartidores de forma concurrente, manteniendo un acceso sincronizado a la zona de carga y evitando que un pedido sea procesado por más de un repartidor.

Al finalizar la ejecución, todos los pedidos quedan correctamente entregados.