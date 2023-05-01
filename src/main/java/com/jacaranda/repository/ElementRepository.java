package com.jacaranda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.model.Element;

public interface ElementRepository extends JpaRepository<Element, String> {

}
