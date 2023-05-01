package com.jacaranda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.model.Element;
import com.jacaranda.repository.ElementRepository;


@Service
public class ElementService {

	@Autowired
	ElementRepository elementRepository;
	
//	obtener lista de elementos
	public List<Element> getElementList() {
		List<Element> elementList = elementRepository.findAll();
		return elementList;
	}
	
//	obtener elemento
	public Element getElement(String elementname) {
		Element element = elementRepository.getReferenceById(elementname);
		return element;
	}
	
//	guardar elemento
	public boolean save(Element element) {
		boolean success = false;
		Element ElementSaved = elementRepository.save(element);
		if(ElementSaved != null) {
			success = true;
		}
		return success;
	}
	
//	borrar elemento
	public void delete(Element element) {
		elementRepository.delete(element);
	}
}
