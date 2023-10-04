package com.william.rapidcargoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;

@Data
@Service
public class EmailService {

	@Autowired
	private Environment environment;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmailWithXmlAttachment(String to, String subject, String body, String attachmentName,
			byte[] xmlData) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body);
		helper.addAttachment(attachmentName, new ByteArrayResource(xmlData));
		javaMailSender.send(message);
	}

}
