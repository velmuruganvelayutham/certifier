package com.certifier.rest.util;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {

	private static String EMAIL = "email";
	private static String PASSWORD = "password";
	private static String MAIL_SMTP_AUTH = "true";
	private static String MAIL_SMTP_STARTTLS = "true";
	private static String MAIL_SMTP_HOST = "smtp.gmail.com";
	private static String MAIL_SMTP_PORT = "587";
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("certifier");
		EMAIL = bundle.getString("mail.from.emailid");
		MAIL_SMTP_AUTH = bundle.getString("mail.smtp.auth");
		MAIL_SMTP_STARTTLS = bundle.getString("mail.smtp.starttls.enable");
		MAIL_SMTP_HOST = bundle.getString("mail.smtp.host");
		MAIL_SMTP_PORT = bundle.getString("mail.smtp.port");
		PASSWORD = bundle.getString("mail.from.password");
		System.out.println("property file has been loaded:");
	}

	public static void send(String to, String subject, String msg) {

		// 1st step) Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.auth", MAIL_SMTP_AUTH);
		props.put("mail.smtp.starttls.enable", MAIL_SMTP_STARTTLS);
		props.put("mail.smtp.host", MAIL_SMTP_HOST);
		props.put("mail.smtp.port", MAIL_SMTP_PORT);

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(EMAIL, PASSWORD);
					}
				});
		// 2nd step)compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject(subject);
			message.setText(msg);

			// 3rd step)send message
			Transport.send(message);

			System.out.println("Email has been sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) {

		Mailer.send("velmurugan.v@sigmainfo.net", "password", "password");
	}
}
