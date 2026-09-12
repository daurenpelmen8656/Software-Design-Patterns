public class Main {
    public static void main(String[] args) {
        EmailDirector director = new EmailDirector();

        EmailObjectBuilder objectBuilder = new EmailObjectBuilder();
        director.makeWelcomeEmail(objectBuilder, "alice@mail.com", "Alice");
        Email welcomeEmail = objectBuilder.getResult();          // representation 1: Email object
        System.out.println(welcomeEmail);

        RawEmailBuilder rawBuilder = new RawEmailBuilder();
        director.makeWelcomeEmail(rawBuilder, "alice@mail.com", "Alice");
        String rawPreview = rawBuilder.getResult();               // representation 2: raw text preview
        System.out.println(rawPreview);
    }
}
