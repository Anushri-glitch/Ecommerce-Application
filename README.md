# Ecommerce-Application
This Application Uses MySQL Database...
##### :purple_square: Its an API Based Web Application
## :one: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA
    3. Postman
    4. SQL
    
## :two: Dependency Used
    1. Spring Web
    2. Spring Boot Dev Tools
    3. Lombok
    4. Spring Data JPA
    5. MySQL Driver
    6. Validation
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :three: Dataflow (Functions Used In)
### :purple_square: 1. Model - Model is used to Iniitialize the required attributes and create the accessable constructors and methods
#### :o: User.java
```java
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private String phone;
}
```

#### :o: Product.java
```java
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private Integer price;
    private String description;
    private String category;
    private String brand;
}
```

#### :o: Address.java
```java
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    private String addressName;
    private String landmark;
    private String phoneNumber;
    private String zipcode;
    private String state;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

#### :o: Orders.java
```java
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private Integer productQuantity;
}
```
##### To See Model
:white_check_mark: [Ecommerce-Model](https://github.com/Anushri-glitch/Ecommerce-Application/tree/master/src/main/java/com/Shrishti/EcommerceApplication/Model)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 2. Service - This Layer is used to write the logic of our CRUD operaions.
#### :o: UserService.java
```java
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public String createUser(List<User> user) {
        userDao.saveAll(user);
        return "User Created";
    }
}
```

#### :o: ProductService.java
```java
@Service
public class ProductService {

    @Autowired
    IProductDao productDao;
    public String createProduct(List<Product> product) {
        productDao.saveAll(product);
        return "Product Created!!!";
    }
}
```

#### :o: AddressService.java
```java
@Service
public class AddressService {

    @Autowired
    IAddressDao addressDao;

    @Autowired
    UserDao userDao;
    public String createAddress(Address address, Integer userId) {
        String result = null;
        if(userDao.existsById(userId)){
            List<Address> addressList = addressDao.findAll();
            ----
            -----
            -----
        }
        return result;
    }
}
```

#### :o: OrdersService.java
```java
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
            -----------
            -----------
            -----------
            result = order.getUser().getUserName();
        }
        return result;
    }
}
```

#### To See Service
:white_check_mark: [Ecommerce-Service](https://github.com/Anushri-glitch/Ecommerce-Application/tree/master/src/main/java/com/Shrishti/EcommerceApplication/Service)
----------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 3. Controller - This Controller is used to like UI between Model and Service and also for CRUD Mappings.
#### :o: UserController.java
```java
@RestController
public class userController {

    @Autowired
    UserService userService;

    //Create User
    @PostMapping(value = "/user")
    public String createUser(@RequestBody List<User> user){
        return userService.createUser(user);
    }
}
```

#### :o: ProductController.java
```java
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value="/product")
    public String createProduct(@RequestBody List<Product> product){
        return productService.createProduct(product);
    }
}
```

#### :o: AddressController.java
```java
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    //Create Address
    @PostMapping(value="/address")
    public ResponseEntity<String> createAddress(@RequestBody Address address, @RequestParam Integer userId){
        String fixAdd = addressService.createAddress(address, userId);
        --------------
        --------------
        --------------
    }
}
```

#### :o: OrdersController.java
```java
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    //CreateOrder
    @PostMapping(value="/orders")
    public ResponseEntity<String> createOrder(@RequestBody Orders order, @RequestParam Integer userId, @RequestParam Integer productId, @RequestParam Integer addressId){
        String fixOrder = orderService.createOrder(order,userId,productId,addressId);
        -----------
        -----------
    }
}
```

#### To See Controller
:white_check_mark: [Ecommerce-Controller](https://github.com/Anushri-glitch/Ecommerce-Application/tree/master/src/main/java/com/Shrishti/EcommerceApplication/Controller)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :purple_square: 3. Repository : data access object (DAO) is an object that provides an abstract interface to some type of database or other persistence mechanisms.
#### :o: IUserDao.java
```java
@Repository
public interface IUserDao extends JpaRepository<Employee,Integer> {
}
```

#### :o: IProductDao.java
```java
@Repository
public interface IProductDao extends JpaRepository<Address,Integer> {
    public List<Product> findByCategory(String category);
}
```

#### :o: IAddressDao.java
```java
@Repository
public interface IAddressDao extends JpaRepository<Address,Integer> {
}
```

#### :o: IOrderDao.java
```java
@Repository
public interface IOrderDao extends JpaRepository<Address,Integer> {
}
```
#### To See Repository
:white_check_mark: [Ecommerce-DAO](https://github.com/Anushri-glitch/Ecommerce-Application/tree/master/src/main/java/com/Shrishti/EcommerceApplication/Dao)
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :four: DataStructures Used in Project
    1. ResponseEntity
    2. List
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :five: DataBase Response In project

:arrow_right: User table
 ```sql
 select * from user;
+---------+-------------------+-----------+-------+-----------+
| user_id | email             | password  | phone | user_name |
+---------+-------------------+-----------+-------+-----------+
|       1 | Anuhska@gmail.com | Anushka01 | 8091  | Anushka   |
|       2 | Richa@gmail.com   | Richa01   | 8091  | Richa     |
+---------+-------------------+-----------+-------+-----------+
```
:arrow_right: Product Table 
```sql
 select * from product;
+------------+-----------------+----------+-------------------------------+-------+---------------------+
| product_id | brand           | category | description                   | price | product_name        |
+------------+-----------------+----------+-------------------------------+-------+---------------------+
|          1 | Glam Roots      | ladies   | Sweart Shirts with cotton mix |  1000 | Sweart Shirt        |
|          2 | Kimayra         | ladies   | Kurta                         |   760 | Floral Flared Kurta |
|          3 | Saffron threads | ladies   | Floral Print Anrkali Kurta    |  1376 | Anarkali Kurta      |
|          4 | Eyebogler       | Gents    | Colour Blocked Polo T-shirt   |   195 | T-shrirt            |
|          5 | London Hills    | Gents    | Polo T-shirt with ribbed hems |   429 | Polo T-shirt        |
|          6 | Bullmer         | Gents    | Striped Henley T-shirt        |   499 | Colur T-shirt       |
+------------+-----------------+----------+-------------------------------+-------+---------------------+
```

:arrow_right: Address Table 

```sql
 select * from address;
+------------+--------------+----------+--------------+---------------+---------+---------+
| address_id | address_name | landmark | phone_number | state         | zipcode | user_id |
+------------+--------------+----------+--------------+---------------+---------+---------+
|          1 | Alopibag     | Chauraha | 8091         | Uttar Pradesh | 211018  |       1 |
|          2 | Beniganj     | Chauraha | 8091         | Uttar Pradesh | 211020  |       2 |
+------------+--------------+----------+--------------+---------------+---------+---------+
```
:arrow_right: Orders Table 

```sql
 select * from orders;
+----------+------------------+------------+------------+---------+
| order_id | product_quantity | address_id | product_id | user_id |
+----------+------------------+------------+------------+---------+
|        1 |                5 |          1 |          3 |       1 |
|        2 |                5 |          2 |          1 |       2 |
+----------+------------------+------------+------------+---------+
```
----------------------------------------------------------------------------------------------------------------------------------------------------------
## :six: Project Summary
### :o: Project result 
#### :purple_square: SAVE USER : http://localhost:8080/user
![Screenshot (783)](https://github.com/Anushri-glitch/Ecommerce-Application/assets/47708011/6d0162a6-a690-47cf-be5b-2e7b745d189d)

#### :purple_square: SAVE PRODUCT : http://localhost:8080/product
![Screenshot (784)](https://github.com/Anushri-glitch/Ecommerce-Application/assets/47708011/bb59f5a4-14ac-4b86-a98b-1f6bc70b1186)

#### :purple_square: SAVE ADDRESS : http://localhost:8080/address
![Screenshot (785)](https://github.com/Anushri-glitch/Ecommerce-Application/assets/47708011/b6435d5f-d085-48cd-9fa5-62f755bb635d)

#### :purple_square: SAVE ORDERS : http://localhost:8080/orders
![Screenshot (786)](https://github.com/Anushri-glitch/Ecommerce-Application/assets/47708011/cd59ec7f-4366-47de-8202-3e2ab5ec26d9)

#### :purple_square: FIND ORDER BY ORDERID : http://localhost:8080/employee
![Screenshot (789)](https://user-images.githubusercontent.com/47708011/236825054-6614b006-9659-41ee-bedb-0e24931e2b8d.png)

#### :purple_square: FIND USER BY USERID : http://localhost:8080/employeeId
![Screenshot (798)](https://user-images.githubusercontent.com/47708011/236825714-388a9185-487d-4c5f-922b-439dcadd9041.png)

#### :purple_square: FIND ALL PRODUCTS BASED ON CATEGORY : http://localhost:8080/employee
![Screenshot (790)](https://user-images.githubusercontent.com/47708011/236825981-0086490b-c829-48e0-a5bf-19a5a3717fa5.png)

#### :purple_square: DELETE PRODUCTS BASED ON PRODUCTID : http://localhost:8080/employee
![Screenshot (791)](https://user-images.githubusercontent.com/47708011/236826279-6db1cdea-d5ec-43a2-9769-d60c211a87f5.png)
----------------------------------------------------------------------------------------------------------------------------------------------------------

