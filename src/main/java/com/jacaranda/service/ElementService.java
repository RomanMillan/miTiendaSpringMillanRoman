package com.jacaranda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jacaranda.model.Category;
import com.jacaranda.model.Element;
import com.jacaranda.repository.ElementRepository;


@Service
public class ElementService {

	@Autowired
	ElementRepository elementRepository;
	@Autowired
	CategoryService categoryService;
	
//	obtener lista de elementos
	public Page<Element> getElementList(
				int numPage, 
				int amountElements, 
				String sortField, 
				String searchField,
				String categoria) {
		Pageable pageable = PageRequest.of(
				numPage -1, 
				amountElements, 
				Sort.by(sortField).ascending());
		
		if (categoria != null) {
			Category category = categoryService.getCategory(categoria);
			return elementRepository.findByCategoryObj(category, pageable);
		}
		if(searchField != null) {
			return elementRepository.findByElementnameLike("%"+ searchField + "%", pageable);
		}else {			
			return elementRepository.findAll(pageable);
		}
	}
	
	
//	obtener elemento
	public Element getElement(String elementname) {
		Element element = elementRepository.findById(elementname).orElse(null);
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
