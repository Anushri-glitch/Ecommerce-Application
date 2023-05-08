package com.Shrishti.EcommerceApplication.Service;

import com.Shrishti.EcommerceApplication.Dao.IProductDao;
import com.Shrishti.EcommerceApplication.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductDao productDao;
    public String createProduct(List<Product> product) {
        productDao.saveAll(product);
        return "Product Created!!!";
    }

    public List<Product> getAllProductsByCategory(String category) {
        return productDao.findByCategory(category);
    }

    public String deleteById(Integer productId) {
        productDao.deleteById(productId);
        return "Product Deleted!!!";
    }
}
