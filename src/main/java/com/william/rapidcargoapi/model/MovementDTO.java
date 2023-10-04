package com.william.rapidcargoapi.model;

import java.time.LocalDateTime;

import com.william.rapidcargoapi.enums.MovementType;

import lombok.Data;

@Data
public class MovementDTO {

	private Long technicalId;
	private LocalDateTime creationTime;
	private String creationUserName;
	private LocalDateTime dateTime;
	private String declarationLocation;
	private String warehouseCode;
	private String warehouseLabel;
	private String customsStatus;
	private String documentType;
	private Long documentRef;

	public MovementIn toMovementIn() {
		MovementIn movementIn = new MovementIn();
		movementIn.setMovementType(MovementType.in.toString());
		movementIn.setTechnicalId(this.getTechnicalId());
		movementIn.setCreationTime(this.getCreationTime());
		movementIn.setCreationUserName(this.getCreationUserName());
		movementIn.setDateTime(this.getDateTime());
		movementIn.setDeclarationLocation(this.getDeclarationLocation());
		movementIn.setWarehouseCode(this.getWarehouseCode());
		movementIn.setWarehouseLabel(this.getWarehouseLabel());
		movementIn.setCustomsStatus(this.getCustomsStatus());
		return movementIn;
	}

	public MovementOut toMovementOut() {
		MovementOut movementOut = new MovementOut();
		movementOut.setMovementType(MovementType.out.toString());
		movementOut.setTechnicalId(this.getTechnicalId());
		movementOut.setCreationTime(this.getCreationTime());
		movementOut.setCreationUserName(this.getCreationUserName());
		movementOut.setDateTime(this.getDateTime());
		movementOut.setDeclarationLocation(this.getDeclarationLocation());
		movementOut.setWarehouseCode(this.getWarehouseCode());
		movementOut.setWarehouseLabel(this.getWarehouseLabel());
		movementOut.setCustomsStatus(this.getCustomsStatus());
		movementOut.setDocumentType(this.getDocumentType());
		movementOut.setDocumentRef(this.getDocumentRef());
		return movementOut;
	}

}
