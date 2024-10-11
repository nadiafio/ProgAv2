package internal.model;
import java.time.LocalDateTime;

public class Message {
    public Message(){}

    private String messageId;
    private String userId;
    private String to;
    private String subject;
    private String replyTo;
    private String correlationId;
    private String contentType;
    private String contentEncoding;
    private LocalDateTime absoluteExpiryTime;
    private LocalDateTime creationTime;
    private String groupId;
    private int groupSequence;
    private String replyToGroupId;

    private String state; // (AVAILABLE, ACQUIRED, ARCHIVED)

    public Message(String messageId) {
        this.messageId = messageId;
        this.creationTime = LocalDateTime.now();
    }

    // Getters y Setters
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public LocalDateTime getAbsoluteExpiryTime() {
        return absoluteExpiryTime;
    }

    public void setAbsoluteExpiryTime(LocalDateTime absoluteExpiryTime) {
        this.absoluteExpiryTime = absoluteExpiryTime;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getGroupSequence() {
        return groupSequence;
    }

    public void setGroupSequence(int groupSequence) {
        this.groupSequence = groupSequence;
    }

    public String getReplyToGroupId() {
        return replyToGroupId;
    }

    public void setReplyToGroupId(String replyToGroupId) {
        this.replyToGroupId = replyToGroupId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
