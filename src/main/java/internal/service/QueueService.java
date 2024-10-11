package internal.service;

import internal.model.Message;
import internal.model.Queue;

public class QueueService {
    private Queue queue = new Queue();

    public void addMessage(Message message) {
        queue.addMessage(message);
    }

    public Message acquireMessage(String messageId) {
        return queue.acquireMessage(messageId);
    }
    public Message archiveMessage() {
        return queue.archiveMessage();
    }

}
