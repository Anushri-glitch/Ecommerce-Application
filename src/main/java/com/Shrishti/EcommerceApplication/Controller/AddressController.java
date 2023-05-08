package com.Shrishti.EcommerceApplication.Controller;

import com.Shrishti.EcommerceApplication.Model.Address;
import com.Shrishti.EcommerceApplication.Model.User;
import com.Shrishti.EcommerceApplication.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    //Create Address
    @PostMapping(value="/address")
    public ResponseEntity<String> createAddress(@RequestBody Address address, @RequestParam Integer userId){
        String fixAdd = addressService.createAddress(address, userId);

        if(fixAdd != null){
            if(fixAdd.equals(" "))
                return new ResponseEntity<>("user does not exist!!!", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(fixAdd + " User Address Saved ", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Null Address!!!", HttpStatus.BAD_REQUEST);
    }
}
