package com.william.rapidcargoapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Movements")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "movement_type")
public class Movement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "movement_type", insertable = false, updatable = false)
	private String movementType;

	@Column(name = "technical_id")
	private Long technicalId;

	@Column(name = "creation_time")
	private LocalDateTime creationTime;

	@Column(name = "creation_user_name")
	private String creationUserName;

	@Column(name = "date_time")
	private LocalDateTime dateTime;

	@Column(name = "declaration_location")
	private String declarationLocation;

}
