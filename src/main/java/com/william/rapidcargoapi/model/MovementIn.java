package com.william.rapidcargoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("in")
@XmlRootElement
public class MovementIn extends Movement {

	@Column(name = "warehouse_code")
	private String warehouseCode;

	@Column(name = "warehouse_label")
	private String warehouseLabel;

	@Column(name = "customs_status")
	private String customsStatus;

}
