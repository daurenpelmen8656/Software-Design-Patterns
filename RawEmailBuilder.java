import java.util.ArrayList;
import java.util.List;

public class RawEmailBuilder implements EmailBuilder {
    private static final String HEADER_FROM = "From: ";
    private static final String HEADER_TO = "To: ";
    private static final String HEADER_SUBJECT = "Subject: ";
    private static final String HEADER_ATTACHMENT = "Attachment: ";
    private static final String LINE_BREAK = "\n";
    private static final String RECIPIENT_SEPARATOR = ", ";

    private String from;
    private final List<String> recipients = new ArrayList<>();
    private String subject;
    private String body;
    private final List<String> attachments = new ArrayList<>();

    @Override
    public RawEmailBuilder setFrom(String from) { this.from = from; return this; }

    @Override
    public RawEmailBuilder addRecipient(String recipient) { recipients.add(recipient); return this; }

    @Override
    public RawEmailBuilder setSubject(String subject) { this.subject = subject; return this; }

    @Override
    public RawEmailBuilder setBody(String body) { this.body = body; return this; }

    @Override
    public RawEmailBuilder addAttachment(String fileName) { attachments.add(fileName); return this; }

    public String getResult() {
        validateRequiredFields();
        return buildRawMessage();
    }

    private void validateRequiredFields() {
        if (from == null || recipients.isEmpty()) {
            throw new IllegalStateException("Sender and at least one recipient are required");
        }
    }

    private String buildRawMessage() {
        StringBuilder raw = new StringBuilder();
        appendHeaders(raw);
        appendAttachments(raw);
        appendBody(raw);
        return raw.toString();
    }

    private void appendHeaders(StringBuilder raw) {
        raw.append(HEADER_FROM).append(from).append(LINE_BREAK);
        raw.append(HEADER_TO).append(String.join(RECIPIENT_SEPARATOR, recipients)).append(LINE_BREAK);
        raw.append(HEADER_SUBJECT).append(subject).append(LINE_BREAK);
    }

    private void appendAttachments(StringBuilder raw) {
        for (String attachment : attachments) {
            raw.append(HEADER_ATTACHMENT).append(attachment).append(LINE_BREAK);
        }
    }

    private void appendBody(StringBuilder raw) {
        raw.append(LINE_BREAK).append(body).append(LINE_BREAK);
    }
}
