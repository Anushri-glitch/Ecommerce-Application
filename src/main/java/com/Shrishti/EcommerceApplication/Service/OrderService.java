package com.Shrishti.EcommerceApplication.Service;

import com.Shrishti.EcommerceApplication.Dao.IAddressDao;
import com.Shrishti.EcommerceApplication.Dao.IOrderDao;
import com.Shrishti.EcommerceApplication.Dao.IProductDao;
import com.Shrishti.EcommerceApplication.Dao.UserDao;
import com.Shrishti.EcommerceApplication.Model.Address;
import com.Shrishti.EcommerceApplication.Model.Orders;
import com.Shrishti.EcommerceApplication.Model.Product;
import com.Shrishti.EcommerceApplication.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    IOrderDao orderDao;

    @Autowired
    UserDao userDao;

    @Autowired
    IProductDao orderProduct;

    @Autowired
    IAddressDao orderAddress;

    public String createOrder(Orders order, Integer userId, Integer productId, Integer addressId) {
        String result = null;

        if(userDao.existsById(userId)){
            List<Orders> orderList = orderDao.findAll();
            for(Orders oldOrder : orderList){
                if(oldOrder.getUser().getUserId().equals(userId) && oldOrder.getProduct().getProductId().equals(productId) && oldOrder.getAddress().getAddressId().equals(addressId)){
                    return " ";
                }
            }
            User userNewOrder = userDao.findById(userId).get();
            Product userNewProduct = orderProduct.findById(productId).get();
            Address userAddress = orderAddress.findById(addressId).get();

            //Set New Order
            order.setUser(userNewOrder);
            order.setProduct(userNewProduct);
            order.setAddress(userAddress);

            //save New Order
            orderDao.save(order);

            result = order.getUser().getUserName();
        }
        return result;
    }

    public Orders getOrderById(Integer orderId) {
        return orderDao.findById(orderId).get();
    }
}
