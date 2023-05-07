package com.Shrishti.EcommerceApplication.Dao;

import com.Shrishti.EcommerceApplication.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDao extends JpaRepository<Order,Integer> {
}
