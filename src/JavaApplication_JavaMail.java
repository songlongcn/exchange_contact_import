/**
 * Created with IntelliJ IDEA.
 * User: michael.song
 * Date: 2/26/14
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */


import java.util.*;

class JavaApplication_JavaMail {
//    public void send_email() throws Exception{
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.j2.com");
//        props.put("mail.from", "michael.song@j2global.com");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.ssl.enable", "false");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "587");
//
//        Authenticator authenticator = new Authenticator();
//        props.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());

//        Session session = Session.getInstance(props, authenticator);
//        MimeMessage msg = new MimeMessage(session);
//        msg.setFrom();
//        msg.setRecipients(Message.RecipientType.TO, "slcntest1@yahoo.com");
//        // also tried @gmail.com
//        msg.setSubject("JavaMail ssl test");
//        msg.setSentDate(new Date());
//        msg.setText("Hello, world!\n");
//
//        Transport transport;
//        transport = session.getTransport("smtp");
//        transport.connect();
//        msg.saveChanges();
//        transport.sendMessage(msg, msg.getAllRecipients());
//        transport.close();
//    }
//    private class Authenticator extends javax.mail.Authenticator {
//        private PasswordAuthentication authentication;
//        public Authenticator() {
//            String username = "michael.song@j2.com";
//            String password = "N0secret";
//            authentication = new PasswordAuthentication(username, password);
//        }
//        protected PasswordAuthentication getPasswordAuthentication() {
//            return authentication;
//        }
//    }

}

