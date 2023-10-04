package com.william.rapidcargoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.william.rapidcargoapi.model.Movement;
import com.william.rapidcargoapi.repository.MovementRepository;

import jakarta.mail.MessagingException;
import jakarta.xml.bind.JAXBException;
import lombok.Data;

@Data
@Service
public class MovementService {

	@Autowired
	private Environment environment;

	@Autowired
	private EmailService emailService;

	@Autowired
	private XmlGenerationService xmlGenerationService;

	@Autowired
	private MovementRepository movementRepository;

	public Iterable<Movement> getMovements() {
		return movementRepository.findAll();
	}

	public Movement postMovement(Movement movement) {
		Movement responseMovement = movementRepository.save(movement);
		setAndSendEmail(responseMovement);
		return responseMovement;
	}

	private void setAndSendEmail(Movement responseMovement) {
		String to = environment.getProperty("spring.mail.receiver");
		String subject = environment.getProperty("spring.mail.subject");
		String body = environment.getProperty("spring.mail.body");
		String attachmentName = environment.getProperty("spring.mail.attachment.name");
		try {
			byte[] xmlData = xmlGenerationService.generateXmlData(responseMovement);
			emailService.sendEmailWithXmlAttachment(to, subject, body, attachmentName, xmlData);
		} catch (MessagingException | JAXBException e) {
			// Gérez les exceptions ici
		}
	}

}
