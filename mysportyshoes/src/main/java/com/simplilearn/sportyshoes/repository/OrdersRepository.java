package com.simplilearn.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.sportyshoes.models.Orders;

public interface OrdersRepository extends JpaRepository <Orders,Integer>{

	@Query(value="SELECT id,final_price, postage, total_price, array_of_basket_items, address, email, name, order_date, ship_date, status FROM orders WHERE order_date >= ? and order_date <= ? order by order_date asc", nativeQuery = true)
	List<Orders> findOrdersUsingOrderDateCYMD(String fromDate, String toDate);

	@Query(value="SELECT id,final_price, postage, total_price, array_of_basket_items, address, email, name, order_date, ship_date, status FROM orders WHERE email = ? order by order_date asc", nativeQuery = true)
	List<Orders> findOrdersUsingEmail(String email);	
	
	@Query(value="SELECT id,final_price, postage, total_price, array_of_basket_items, address, email, name, order_date, ship_date, status FROM orders WHERE id in (SELECT orders_Id FROM ordertransitemhist WHERE orders_Id = ?)", nativeQuery = true)
	List<Orders> findOrdersUsingCategory(int id);
	
	
}
