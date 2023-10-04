package com.william.rapidcargoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.william.rapidcargoapi.enums.MovementType;
import com.william.rapidcargoapi.model.Movement;
import com.william.rapidcargoapi.model.MovementDTO;
import com.william.rapidcargoapi.service.MovementService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class MovementController {

	@Autowired
	private MovementService movementService;

	@GetMapping("/movements")
	public Iterable<Movement> getMovements() {
		return movementService.getMovements();
	}

	@GetMapping("/movements/latest")
	public Iterable<Movement> getLastMovements() {
		return movementService.getLastMovements();
	}

	@PostMapping("/movement")
	public Movement postMovement(@RequestBody MovementDTO movementData,
			@RequestParam(name = "type", required = true) MovementType movementType) {
		Movement movement = movementType.toString() == "in" ? movementData.toMovementIn()
				: movementData.toMovementOut();
		return movementService.postMovement(movement);
	}

}
