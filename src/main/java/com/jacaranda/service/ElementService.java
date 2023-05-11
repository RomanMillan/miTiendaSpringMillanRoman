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
				String categoryId) {
		Pageable pageable = PageRequest.of(
				numPage -1, 
				amountElements, 
				Sort.by(sortField).ascending());
		if(searchField != null && categoryId != null) {
			Category cat = categoryService.getCategory(categoryId);
			return elementRepository.findByCategoryAndSearchField(cat,"%"+ searchField + "%", pageable);
		}else if(searchField == null && categoryId != null) {
			Category cat = categoryService.getCategory(categoryId);
			return elementRepository.findByCategory(cat,pageable);
		}else if(searchField != null && categoryId == null) {
			return elementRepository.findByElementnameLike("%"+ searchField + "%", pageable);
		}else {			
			return elementRepository.findAll(pageable);
		}
	}
	
// Obtener por categorias
//public Page<Element> findAllByCategory(
//		int pageNum, 
//		int pageSize, 
//		String sortField, 
//		String stringFind, 
//		int catId){
//		
//	Pageable pageable = PageRequest.of(
//			pageNum - 1, 
//			pageSize, 
//			Sort.by(sortField).ascending());
//	
//	if(stringFind.equals("")) {
//		return elementRepository.findByCategory(catId, pageable);
//	}else {
//		return elementRepository.findByCategoryCatIdAndNameLike(catId, "%" + stringFind + "%", pageable); 
//	}
//		
//}
	
	
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
