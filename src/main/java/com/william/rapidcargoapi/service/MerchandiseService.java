package com.william.rapidcargoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.william.rapidcargoapi.model.Merchandise;
import com.william.rapidcargoapi.model.Movement;
import com.william.rapidcargoapi.repository.MerchandiseRepository;

import lombok.Data;

@Data
@Service
public class MerchandiseService {

	@Autowired
	private MerchandiseRepository merchandiseRepository;

	public void extractAndSaveMerchandise(Movement movement) {
		Merchandise merchandise = extractMerchandise(movement);
		merchandiseRepository.save(merchandise);
	}

	private Merchandise extractMerchandise(Movement movement) {
		Merchandise merchandise = new Merchandise();
		merchandise = movement.getMerchandise();
		return merchandise;
	}

}
