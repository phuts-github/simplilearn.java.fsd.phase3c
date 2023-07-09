package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.models.Products;

public interface ProductsRepository extends JpaRepository <Products,Integer>{

}
