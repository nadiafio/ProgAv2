# Analisis de Negocio 

En este proyecto, como Analista, se implementará un sistema que simula la operación de colas de mensajes para una aplicación de delivery. 
Se requiere gestionar los pedidos y su procesamiento, simulando AMQP. Esto ayudará a que se manejen correctamente temas como el orden de entrega, actualización de los estados y permitiendo que el sistema funcione de manera asíncrona y escalable.
El cliente enviará los pedidos, los cuales serán encolados en el sistema (Broker), y se podrán adquirir o archivar los mensajes, simulando el procesamiento de las ordenes de delivery.

## Tareas a Desarrollar:

### Setup con Spring Boot: 
Iniciaremos un proyecto en Java Spring Boot, se construye una API REST que gestione los pedidos encolados.

**Esfuerzo estimado**: 1 punto

### Definir la clase Order:
Se crearan la clases correspondiente para la estructura que contendrá los pedidos. Debera tener atributos como:
- `ID del pedido`
- `Nombre del cliente`
- `Dirección de entrega`
- `Estado del pedido` (variable, según el estado en el que se encuentre podria ser: AVAILABLE, ACQUIRED, ARCHIVED)
- `Fecha de creación del pedido`
La clase tendrá un constructor que automáticamente asigne la fecha de creación y un ID incremental único para cada nuevo pedido.

**Esfuerzo estimado**: 1 punto

### Crear el service DeliveryQueueService: 
El servicio DeliveryQueueService gestionará las operaciones de la cola, siguiendo lógica del negocio. Tendrá los siguientes métodos:
- `addOrder`: Agrega un nuevo pedido a la cola
- `getAllOrders`: Devuelve todos los pedidos en la cola, para saber cuales siguen pendientes y cuales no.
- `acquireOrders`: Obtiene el primer pedido de la cola por su ID y cambia su estado a ACQUIRED (es decir, el pedido está en proceso).
- `archiveOrders`: Elimina el primer pedido de la cola y lo archiva, cuando la entrega ha sido completada.

**Esfuerzo estimado**: 2 puntos

## Endpoints para Postman

El sistema expondrá estos endpoints:
### `POST /orders`: 
Permite enviar un nuevo pedido (lo envia a la cola de pedidos).
### `GET /orders`: 
Devuelve la lista de todos los pedidos pendientes.
### `GET /orders/acquire/{id}`: 
Permite adquirir un pedido por su ID y cambiar su estado a ACQUIRED.
### `DELETE /orders/archive`: 
Archiva (y elimina) el primer pedido en la cola, cuando la entrega ya se completó, se cambia su estado a ARCHIVED.

**Esfuerzo estimado**: 3 puntos

### **Total esfuerzo estimado**: 7 puntos, lo que corresponderia a 7 dias de trabajo

