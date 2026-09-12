public interface EmailBuilder {
    EmailBuilder setFrom(String from);
    EmailBuilder addRecipient(String recipient);
    EmailBuilder setSubject(String subject);
    EmailBuilder setBody(String body);
    EmailBuilder addAttachment(String fileName);
}
