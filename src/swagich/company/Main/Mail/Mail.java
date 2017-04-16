package swagich.company.Main.Mail;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class Mail {

    protected static final String SMTP_HOST_NAME = "smtp.gmail.com";
    protected static final int SMTP_HOST_PORT = 465;

    public void sendMail(String From, String FromPwd, String To, String subject, String msg) throws Exception {
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", SMTP_HOST_NAME);
        props.put("mail.smtps.auth", "true");
        // props.put("mail.smtps.quitwait", "false");

        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(subject);
        message.setText(msg);

        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(To));
        message.setReplyTo(null);

        transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, From, FromPwd);

        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
}
