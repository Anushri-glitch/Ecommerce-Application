package com.Shrishti.EcommerceApplication.Dao;

import com.Shrishti.EcommerceApplication.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressDao extends JpaRepository<Address,Integer> {
}
