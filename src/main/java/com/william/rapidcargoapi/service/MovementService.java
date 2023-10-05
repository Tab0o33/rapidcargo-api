package com.william.rapidcargoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.william.rapidcargoapi.model.Movement;
import com.william.rapidcargoapi.repository.MovementRepository;

import lombok.Data;

@Data
@Service
public class MovementService {

	@Autowired
	private Environment environment;

	@Autowired
	private EmailService emailService;

	@Autowired
	private MerchandiseService merchandiseService;

	@Autowired
	private MovementRepository movementRepository;

	public Iterable<Movement> getMovements() {
		return movementRepository.findAll();
	}

	public Iterable<Movement> getLastMovements() {
		return movementRepository.findTop50ByOrderByDateTimeDesc();
	}

	public Movement postMovement(Movement movement) {
		merchandiseService.extractAndSaveMerchandise(movement);
		Movement responseMovement = movementRepository.save(movement);
		emailService.setAndSendEmail(responseMovement);
		return responseMovement;
	}

}
