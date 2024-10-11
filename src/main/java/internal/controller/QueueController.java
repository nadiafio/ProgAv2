package internal.controller;

import internal.model.Message;
import internal.service.QueueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {

    private final QueueService queueService = new QueueService();

    @PostMapping("/message")
    public void addMessage(@RequestBody Message message) {
        message.setState("AVAILABLE");
        queueService.addMessage(message);
    }

    @GetMapping("/message/{id}")
    public Message acquireMessage(@PathVariable("id") String messageId) {
        return queueService.acquireMessage(messageId);
    }

    @GetMapping("/message")
    public Message archiveMessage() {
        return queueService.archiveMessage();
    }

}
