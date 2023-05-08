package com.Shrishti.EcommerceApplication.Dao;

import com.Shrishti.EcommerceApplication.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDao extends JpaRepository<Orders,Integer> {
}
