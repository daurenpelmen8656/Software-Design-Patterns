import java.util.List;

public final class Email {
    private final String from;
    private final List<String> to;
    private final String subject;
    private final String body;
    private final List<String> attachments;

    Email(String from, List<String> to, String subject, String body, List<String> attachments) {
        this.from = from;
        this.to = List.copyOf(to);
        this.subject = subject;
        this.body = body;
        this.attachments = List.copyOf(attachments);
    }

    public String getFrom() { return from; }
    public List<String> getTo() { return to; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public List<String> getAttachments() { return attachments; }

    @Override
    public String toString() {
        return "Email[from=" + from + ", to=" + to + ", subject=" + subject + "]";
    }
}
