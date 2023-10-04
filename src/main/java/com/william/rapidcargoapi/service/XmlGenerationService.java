package com.william.rapidcargoapi.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.william.rapidcargoapi.model.Movement;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

@Service
public class XmlGenerationService {

	public byte[] generateXmlData(Movement dataObject) throws JAXBException {
		// Crée une instance de JAXBContext
		JAXBContext context = JAXBContext.newInstance(dataObject.getClass());
		// Crée un Marshaller pour convertir l'objet en XML
		Marshaller marshaller = context.createMarshaller();
		// Convertit l'objet en XML
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(dataObject, outputStream);
		// Récupère le contenu XML sous forme de tableau d'octets
		return outputStream.toByteArray();
	}

}
