# SpeedFastApp - Semana 3

## Desarrollo Orientado a Objetos II

Proyecto desarrollado para la actividad de la Semana 3 de la asignatura Desarrollo Orientado a Objetos II.

El sistema representa una aplicación de entregas para la empresa **SpeedFast**, aplicando conceptos de Programación Orientada a Objetos como herencia, abstracción, polimorfismo e interfaces.

---

## Objetivo

Desarrollar un sistema de gestión de pedidos utilizando:

- Herencia.
- Clases abstractas.
- Sobrescritura de métodos.
- Sobrecarga de métodos.
- Polimorfismo.
- Interfaces.
- Colecciones mediante ArrayList.
- Separación de responsabilidades.

---

## Estructura del proyecto

El proyecto está compuesto por una clase abstracta llamada `Pedido` y tres clases derivadas:

- `PedidoComida`
- `PedidoEncomienda`
- `PedidoExpress`

Además, se implementan las siguientes interfaces:

- `Despachable`
- `Cancelable`
- `Rastreable`

La clase `Main` permite ejecutar y comprobar el funcionamiento completo del sistema.

---

## Clase abstracta Pedido

La clase `Pedido` contiene los atributos y comportamientos comunes de todos los pedidos:

- ID del pedido.
- Dirección de entrega.
- Distancia.
- Repartidor.
- Estado del pedido.

También contiene el método implementado:

`mostrarResumen()`

y el método abstracto:

`calcularTiempoEntrega()`

Cada subclase implementa su propia lógica para calcular el tiempo estimado de entrega.

---

## Polimorfismo

El proyecto utiliza polimorfismo mediante sobrescritura y sobrecarga de métodos.

### Sobrescritura

Cada tipo de pedido sobrescribe:

`asignarRepartidor()`

De esta manera, cada clase puede asignar automáticamente un repartidor diferente.

También se sobrescribe:

`calcularTiempoEntrega()`

permitiendo que cada tipo de pedido utilice una lógica distinta para calcular su tiempo de entrega.

### Sobrecarga

La clase `Pedido` incorpora el método:

`asignarRepartidor(String nombre)`

Este método permite realizar una asignación manual del repartidor.

---

## Interfaces

Se utilizan tres interfaces para separar responsabilidades dentro del sistema.

### Despachable

Contiene el método:

`despachar()`

Permite cambiar el estado de un pedido a despachado.

### Cancelable

Contiene el método:

`cancelar()`

Permite cancelar un pedido.

### Rastreable

Contiene el método:

`verHistorial()`

Permite visualizar información asociada a los pedidos almacenados en el historial.

---

## Simulación

La clase `Main` crea tres pedidos diferentes:

### PedidoComida

- Pedido #101
- Asignación automática de repartidor.
- Cálculo del tiempo estimado.
- Despacho del pedido.

### PedidoEncomienda

- Pedido #102
- Asignación manual de repartidor.
- Cálculo del tiempo estimado.
- Despacho del pedido.

### PedidoExpress

- Pedido #103
- Asignación automática de repartidor.
- Cálculo del tiempo estimado.
- Cancelación del pedido.

Posteriormente, los pedidos son almacenados en un `ArrayList` y se muestra su historial.

---

## Ejemplo de salida

```text
----- DEMOSTRACIÓN DE POLIMORFISMO -----

Pedido #101 - Tiempo estimado: 30 minutos
Pedido #102 - Tiempo estimado: 36 minutos
Pedido #103 - Tiempo estimado: 14 minutos

----- HISTORIAL DE PEDIDOS -----

PedidoComida #101 | Repartidor: Luis Díaz | Estado: Despachado
PedidoEncomienda #102 | Repartidor: Daniela Tapia | Estado: Despachado
PedidoExpress #103 | Repartidor: Carlos Soto | Estado: Cancelado