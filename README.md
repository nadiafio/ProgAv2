# Operaciones de Cola con Spring Boot (similar a AMQP)

Este proyecto de Spring Boot implementa un sistema básico de gestión de colas inspirado en AMQP, sin utilizar bibliotecas o frameworks relacionados con AMQP. Se definen tres estados de mensajes: `AVAILABLE`, `ACQUIRED` y `ARCHIVED`, y se gestionan los mensajes en una cola FIFO (First In, First Out).

## Tabla de Contenidos
- [Descripción general](#descripción-general)
- [Inicialización del proyecto](#inicialización-del-proyecto)
- [Estados de los mensajes](#estados-de-los-mensajes)
- [Propiedades de los mensajes](#inicialización-del-proyecto)
- [Endpoints](#endpoints)

## Descripción general

El sistema simula transiciones de estados de mensajes como se utiliza en AMQP:

- **AVAILABLE**: Los mensajes comienzan en este estado cuando se añaden a la cola.
- **ACQUIRED**: Cuando un mensaje se obtiene por su ID, pasa al estado ACQUIRED.
- **ARCHIVED**: Cuando un mensaje se elimina de la cola, pasa al estado ARCHIVED.

Se presenta una API REST para las operaciones de cola, y los estados van cambiando según las requests.

## Inicialización del proyecto

1. Clona este repositorio en tu máquina local.
2. Navega al directorio del proyecto.
3. Ejecuta el siguiente comando para inicializar el proyecto:
   mvn spring-boot:run

## Estados de los mensajes

### 1. AVAILABLE
   Un mensaje comienza en este estado cuando se añade a la cola.

### 2. ACQUIRED
   El mensaje pasa a ACQUIRED cuando se obtiene por su ID. Luego de ser adquirido, el mensaje ya no está disponible para otras operaciones excepto su eliminación.

### 3. ARCHIVED
   Cuando un mensaje es desencolado, pasa al estado ARCHIVED.

## Propiedades de los mensajes
    Los mensajes tienen una estructura con estos campos:
- `message-id`: Identificador único del mensaje.
- `user-id`: ID del usuario que crea el mensaje.
- `to`: Dirección del nodo al que se destina el mensaje.
- `subject`: Asunto del mensaje.
- `reply-to`: Dirección del nodo para enviar respuestas.
- `correlation-id`: ID de correlación del mensaje.
- `content-type`: Tipo de contenido del mensaje (MIME).
- `content-encoding`: Codificación de contenido del mensaje.
- `absolute-expiry-time`: Tiempo en que el mensaje se considera expirado.
- `creation-time`: Tiempo en que se creó el mensaje.
- `group-id`: Grupo al que pertenece el mensaje.
- `group-sequence`: Número de secuencia del mensaje dentro de su grupo.
- `reply-to-group-id`: Grupo al que pertenece el mensaje de respuesta.

## Endpoints

### POST `/queue/message`
- **Descripción**: Añade un nuevo mensaje a la cola con el estado `AVAILABLE`.
- **Ejemplo - Cuerpo de la Solicitud**:
  ```json
  {
    "message-id": "12345",
    "user-id": "usuario1",
    "to": "direccionDestino",
    "subject": "Asunto del mensaje",
    "reply-to": "direccionRespuesta",
    "correlation-id": "correlacion123",
    "content-type": "text/plain",
    "content-encoding": "utf-8",
    "absolute-expiry-time": "2024-10-10T10:00:00Z",
    "creation-time": "2024-10-10T09:00:00Z",
    "group-id": "grupo1",
    "group-sequence": 1,
    "reply-to-group-id": "grupoRespuesta"
  }

### GET `/queue/message/{id}`
- **Descripción**: Obtiene un mensaje de la cola por su ID y lo marca como `ACQUIRED`.
- **Ejemplo de solicitud**: `GET /queue/message/12345`
- **Respuesta**:
  ```json
  {
    "message-id": "12345",
    "user-id": "usuario1",
    "to": "direccionDestino",
    "subject": "Asunto del mensaje",
    "reply-to": "direccionRespuesta",
    "correlation-id": "correlacion123",
    "content-type": "text/plain",
    "content-encoding": "utf-8",
    "absolute-expiry-time": "2024-10-10T10:00:00Z",
    "creation-time": "2024-10-10T09:00:00Z",
    "group-id": "grupo1",
    "group-sequence": 1,
    "reply-to-group-id": "grupoRespuesta",
    "state": "ACQUIRED"
  }

### GET `/queue/message`
- **Descripción**: Elimina el primer mensaje de la cola y lo marca como `ARCHIVED`.
- **Cuerpo de la Solicitud**:
  ```json
  {
    "message-id": "12345",
    "user-id": "usuario1",
    "to": "direccionDestino",
    "subject": "Asunto del mensaje",
    "reply-to": "direccionRespuesta",
    "correlation-id": "correlacion123",
    "content-type": "text/plain",
    "content-encoding": "utf-8",
    "absolute-expiry-time": "2024-10-10T10:00:00Z",
    "creation-time": "2024-10-10T09:00:00Z",
    "group-id": "grupo1",
    "group-sequence": 1,
    "reply-to-group-id": "grupoRespuesta",
    "state": "ARCHIVED"
  }
