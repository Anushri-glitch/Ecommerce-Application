package com.Shrishti.EcommerceApplication.Controller;

import com.Shrishti.EcommerceApplication.Model.Orders;
import com.Shrishti.EcommerceApplication.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    //CreateOrder
    @PostMapping(value="/orders")
    public ResponseEntity<String> createOrder(@RequestBody Orders order, @RequestParam Integer userId, @RequestParam Integer productId, @RequestParam Integer addressId){
        String fixOrder = orderService.createOrder(order,userId,productId,addressId);

        if(fixOrder != null){
            if(fixOrder.equals(" ")){
                return new ResponseEntity<>("Order Already Placed!!!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(fixOrder + " Your Order Is Placed!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Invalid Order!!!", HttpStatus.BAD_REQUEST);
    }

    //Get Order By OrderId
    @GetMapping(value = "/orders")
    public Orders getOrderById(@RequestParam Integer orderId){
        return orderService.getOrderById(orderId);
    }
}
