package com.velmurugan.certifier.component;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Component
public class VelocityEmailSender {

	private static final String FORGOT_PASSWORD_TEMPLATE = "/forgotPasswordTemplate.vm";

	private static final String UTF_8 = "UTF-8";

	private static final String REGISTRATION_TEMPLATE = "/registrationTemplate.vm";

	private static final Logger logger = LoggerFactory.getLogger(VelocityEmailSender.class);

	private final VelocityEngine velocityEngine;

	private final JavaMailSender mailSender;

	@Autowired
	SimpleMailMessage templateMessage;

	/**
	 * Constructor
	 */
	@Autowired
	public VelocityEmailSender(VelocityEngine velocityEngine, JavaMailSender mailSender) {
		this.velocityEngine = velocityEngine;
		this.mailSender = mailSender;
	}

	/**
	 * Sends e-mail using Velocity template for the body and the properties
	 * passed in as Velocity variables.
	 *
	 * @param msg
	 *            The e-mail message to be sent, except for the body.
	 * @param hTemplateVariables
	 *            Variables to use when processing the template.
	 */
	public void sendEmailConfirmation(final String toMail, final Map<String, Object> hTemplateVariables) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(toMail);
				message.setFrom(templateMessage.getFrom());
				message.setSubject(templateMessage.getSubject());

				String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, REGISTRATION_TEMPLATE, UTF_8,
						hTemplateVariables);

				logger.info("body={}", body);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);

		logger.info("Sent e-mail to '{}'.", toMail);
	}

	/**
	 * Sends e-mail using Velocity template for the body and the properties
	 * passed in as Velocity variables.
	 *
	 * @param msg
	 *            The e-mail message to be sent, except for the body.
	 * @param hTemplateVariables
	 *            Variables to use when processing the template.
	 */
	public void sendPassword(final String toMail, final Map<String, Object> hTemplateVariables) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(toMail);
				message.setFrom(templateMessage.getFrom());
				message.setSubject("Forgot Passord Request");

				String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, FORGOT_PASSWORD_TEMPLATE,
						UTF_8, hTemplateVariables);

				logger.info("body={}", body);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);

		logger.info("Sent e-mail to '{}'.", toMail);
	}

}
