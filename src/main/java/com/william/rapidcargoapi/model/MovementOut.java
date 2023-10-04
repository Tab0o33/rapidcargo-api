package com.william.rapidcargoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("out")
public class MovementOut extends Movement {

	@Column(name = "warehouse_code")
	private String warehouseCode;

	@Column(name = "warehouse_label")
	private String warehouseLabel;

	@Column(name = "customs_status")
	private String customsStatus;

	@Column(name = "document_type")
	private String documentType;

	@Column(name = "document_ref")
	private Long documentRef;

}
