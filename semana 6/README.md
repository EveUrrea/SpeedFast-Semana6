# SpeedFast - Semana 6

## Diseñando interfaces gráficas con Swing en Java

En esta actividad se implementó una interfaz gráfica para el sistema de gestión de entregas de SpeedFast utilizando Java Swing.

La aplicación permite registrar pedidos, visualizar los pedidos almacenados y asignar un repartidor para iniciar una entrega.

## Estructura del proyecto

El proyecto se encuentra organizado en los siguientes paquetes:

### modelo
Contiene las clases relacionadas con la lógica del sistema:

- Pedido
- PedidoComida
- PedidoEncomienda
- PedidoExpress
- Repartidor
- Cancelable
- Despachable
- Rastreable

### vista
Contiene las interfaces gráficas desarrolladas con Swing:

- VentanaPrincipal
- VentanaRegistroPedido
- VentanaListaPedidos
- VentanaAsignarEntrega

### main
Contiene la clase Main encargada de iniciar la aplicación.

## Funcionalidades

### Ventana principal

La aplicación inicia mostrando un menú principal con las siguientes opciones:

- Registrar pedido
- Listar pedidos
- Asignar repartidor / Iniciar entrega

### Registro de pedidos

Permite ingresar los siguientes datos:

- ID del pedido
- Dirección de entrega
- Distancia en kilómetros
- Tipo de pedido

Los tipos disponibles son:

- Comida
- Encomienda
- Express

Antes de registrar un pedido se validan los datos ingresados.

El sistema verifica que:

- No existan campos vacíos.
- El ID sea un número válido y mayor a cero.
- La distancia sea un número válido y mayor a cero.
- No exista otro pedido con el mismo ID.

Cuando el registro se realiza correctamente, se muestra un mensaje de confirmación utilizando JOptionPane.

### Listado de pedidos

Los pedidos registrados pueden visualizarse mediante una JTable.

La tabla utiliza DefaultTableModel y muestra:

- ID
- Dirección
- Distancia
- Tipo
- Repartidor
- Estado

Los datos de la tabla se obtienen desde la lista de pedidos almacenada en memoria.

También se incorporó un botón para actualizar la información mostrada.

### Asignación de repartidor

El sistema permite seleccionar un pedido registrado e ingresar el nombre de un repartidor.

Al iniciar la entrega:

- Se asigna el repartidor al pedido.
- El estado cambia de "Pendiente" a "En entrega".
- Se muestra un mensaje confirmando el inicio de la entrega.

## Almacenamiento de datos

Para esta actividad los pedidos se almacenan temporalmente en memoria utilizando una lista:

```java
List<Pedido>
```

La misma lista es compartida entre las distintas ventanas de la aplicación.

## Tecnologías utilizadas

- Java
- Java Swing
- JFrame
- JPanel
- JButton
- JLabel
- JTextField
- JComboBox
- JOptionPane
- JTable
- DefaultTableModel
- ArrayList
- IntelliJ IDEA
- Git
- GitHub

## Ejecución

La aplicación se inicia desde:

```text
src/main/Main.java
```

La clase Main utiliza SwingUtilities.invokeLater para iniciar la interfaz gráfica:

```java
SwingUtilities.invokeLater(() -> {
    new VentanaPrincipal();
});
```

## Resultado

Se desarrolló una interfaz gráfica funcional para SpeedFast que permite gestionar pedidos mediante ventanas Swing.

El sistema reutiliza las clases desarrolladas previamente y mantiene una separación entre el modelo de datos, las vistas y la clase principal de ejecución.