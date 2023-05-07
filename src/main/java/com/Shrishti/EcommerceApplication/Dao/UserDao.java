package com.Shrishti.EcommerceApplication.Dao;

import com.Shrishti.EcommerceApplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
}
