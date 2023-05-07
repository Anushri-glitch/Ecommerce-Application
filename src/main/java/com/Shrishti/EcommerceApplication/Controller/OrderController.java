package com.Shrishti.EcommerceApplication.Controller;

import com.Shrishti.EcommerceApplication.Dao.IAddressDao;
import com.Shrishti.EcommerceApplication.Dao.IProductDao;
import com.Shrishti.EcommerceApplication.Dao.UserDao;
import com.Shrishti.EcommerceApplication.Model.Order;
import com.Shrishti.EcommerceApplication.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    //CreateOrder
    @PostMapping(value="/order")
    public ResponseEntity<String> createOrder(@RequestBody Order order, @RequestParam Integer userId, @RequestParam Integer productId, @RequestParam Integer addressId){
        String fixOrder = orderService.createOrder(order,userId,productId,addressId);

        if(fixOrder != null){
            if(fixOrder.equals(" ")){
                return new ResponseEntity<>("Order Already Placed!!!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(fixOrder + "Order Created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Invalid Order!!!", HttpStatus.BAD_REQUEST);
    }
}
