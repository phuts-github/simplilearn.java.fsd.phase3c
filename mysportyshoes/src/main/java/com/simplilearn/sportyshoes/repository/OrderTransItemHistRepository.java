package com.simplilearn.sportyshoes.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.sportyshoes.models.OrderTransItemHist;

public interface OrderTransItemHistRepository extends JpaRepository <OrderTransItemHist,Integer>{

	@Query(value="SELECT brand, category, color, descr, id, order_datecymd, orders_Id, price, size, status FROM ordertransitemhist WHERE Category = ? order by order_datecymd asc", nativeQuery = true)
	List<OrderTransItemHist> findOrderTransItemHistUsingCategory(String id);
	
	@Query(value="SELECT brand, category, color, descr, id, order_datecymd, orders_Id, price, size, status FROM ordertransitemhist WHERE order_datecymd >= ? and order_datecymd<=? order by order_datecymd asc", nativeQuery = true)
	ArrayList<OrderTransItemHist> findOrderTransItemHistUsingOrderDateCYMD(String fromDate, String toDate);

	@Query(value="SELECT brand, category, color, descr, id, order_datecymd, orders_Id, price, size, status FROM ordertransitemhist WHERE orders_Id >= ? ", nativeQuery = true)
	ArrayList<OrderTransItemHist> findOrderTransItemHistUsingOrderId(String id);
}
