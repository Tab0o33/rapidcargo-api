package com.william.rapidcargoapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Merchandises")
public class Merchandise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@Column(name = "reference_type")
	private String referenceType;

	@Column(name = "reference_value")
	private Long referenceValue;

	private Long quantity;

	private Long weight;

	@Column(name = "total_quantity")
	private Long totalQuantity;

	@Column(name = "total_weight")
	private Long totalWeight;

	@Column(name = "m_description")
	private String description;

	@JsonIgnore
	@OneToOne(mappedBy = "merchandise")
	private Movement movement;

}
