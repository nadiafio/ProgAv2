package internal.model;

import java.util.LinkedList;

public class Queue {
    private LinkedList<Message> messages = new LinkedList<>(); // cola (FIFO)

    public void addMessage(Message message) {
        messages.offer(message); // el msje se agrega al final de la cola
    }
    public Message acquireMessage(String messageId) {
        for (Message message : messages) {
            if (message.getMessageId().equals(messageId) && message.getState().equals("AVAILABLE")) {
                message.setState("ACQUIRED"); // cambia el estado del msj a ACQUIRED
                return message;
            }
        }
        return null;
    }
    public Message archiveMessage() {
        if (!messages.isEmpty()) {
            Message message = messages.poll(); // saca el primer msje en la cola
            if (message != null) {
                message.setState("ARCHIVED"); // cambia el estado del msje a ARCHIVED
            }
            return message;
        }
        return null; 
    }

}
