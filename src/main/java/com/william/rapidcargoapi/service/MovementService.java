package com.william.rapidcargoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.william.rapidcargoapi.model.Movement;
import com.william.rapidcargoapi.repository.MovementRepository;

import lombok.Data;

@Data
@Service
public class MovementService {

	@Autowired
	private MovementRepository movementRepository;

	public Iterable<Movement> getMovements() {
		return movementRepository.findAll();
	}

	public Movement postMovement(Movement movement) {
		return movementRepository.save(movement);
	}

}
