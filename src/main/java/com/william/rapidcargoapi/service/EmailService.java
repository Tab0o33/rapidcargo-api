package com.william.rapidcargoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.william.rapidcargoapi.model.Movement;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.xml.bind.JAXBException;
import lombok.Data;

@Data
@Service
public class EmailService {

	@Autowired
	private Environment environment;

	@Autowired
	private XmlGenerationService xmlGenerationService;

	@Autowired
	private JavaMailSender javaMailSender;

	public void setAndSendEmail(Movement responseMovement) {
		try {
			byte[] xmlData = xmlGenerationService.generateXmlData(responseMovement);
			sendEmailWithXmlAttachment(xmlData);
		} catch (MessagingException | JAXBException e) {
			// Gérer les exceptions ici
		}
	}

	public void sendEmailWithXmlAttachment(byte[] xmlData) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(environment.getProperty("spring.mail.receiver"));
		helper.setSubject(environment.getProperty("spring.mail.subject"));
		helper.setText(environment.getProperty("spring.mail.body"));
		helper.addAttachment(environment.getProperty("spring.mail.attachment.name"), new ByteArrayResource(xmlData));
		javaMailSender.send(message);
	}
}
