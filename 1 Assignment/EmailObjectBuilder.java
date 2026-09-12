import java.util.ArrayList;
import java.util.List;

/** Concrete builder #1 — produces an immutable Email object. */
public class EmailObjectBuilder implements EmailBuilder {
    private String from;
    private final List<String> recipients = new ArrayList<>();
    private String subject;
    private String body;
    private final List<String> attachments = new ArrayList<>();

    @Override
    public EmailObjectBuilder setFrom(String from) { this.from = from; return this; }

    @Override
    public EmailObjectBuilder addRecipient(String recipient) { recipients.add(recipient); return this; }

    @Override
    public EmailObjectBuilder setSubject(String subject) { this.subject = subject; return this; }

    @Override
    public EmailObjectBuilder setBody(String body) { this.body = body; return this; }

    @Override
    public EmailObjectBuilder addAttachment(String fileName) { attachments.add(fileName); return this; }

    public Email getResult() {
        validateRequiredFields();
        return new Email(from, recipients, subject, body, attachments);
    }

    private void validateRequiredFields() {
        if (from == null || recipients.isEmpty()) {
            throw new IllegalStateException("Sender and at least one recipient are required");
        }
    }
}
