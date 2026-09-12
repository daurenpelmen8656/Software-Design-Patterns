public class EmailDirector {
    private static final String NO_REPLY_ADDRESS = "no-reply@company.com";
    private static final String SECURITY_TIPS_ATTACHMENT = "security-tips.pdf";

    public void makeWelcomeEmail(EmailBuilder builder, String recipient, String userName) {
        builder.setFrom(NO_REPLY_ADDRESS)
               .addRecipient(recipient)
               .setSubject("Welcome to our platform!")
               .setBody(buildWelcomeBody(userName));
    }

    public void makePasswordResetEmail(EmailBuilder builder, String recipient, String resetLink) {
        builder.setFrom(NO_REPLY_ADDRESS)
               .addRecipient(recipient)
               .setSubject("Password reset request")
               .setBody(buildPasswordResetBody(resetLink))
               .addAttachment(SECURITY_TIPS_ATTACHMENT);
    }

    private String buildWelcomeBody(String userName) {
        return "Hi " + userName + ", thanks for joining us!";
    }

    private String buildPasswordResetBody(String resetLink) {
        return "Click here to reset your password: " + resetLink;
    }
}
