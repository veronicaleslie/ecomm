package com.revature.ecomm.order;

import com.revature.ecomm.Merch.Merch;
import com.revature.ecomm.Merch.MerchService;
import com.revature.ecomm.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class OrderServlet {
    private final OrderService orderService;
    private final MerchService merchService;
    @Autowired
    public OrderServlet(OrderService orderService, MerchService merchService){
        this.merchService = merchService;
        this.orderService = orderService;
    }
    @PostMapping("/order")
    public ResponseEntity<Order> CreateCreditCard(@RequestBody OrderInitializer initOrder, HttpSession req){
        Order newOrder = new Order();
        User authUser = (User) req.getAttribute("authUser");

        Merch itemName = merchService.readById(initOrder.getItemName());
        newOrder.setOrderDate(initOrder.getOrderDate());
        newOrder.setColor(initOrder.getColor());
        newOrder.setUsername(authUser);
        newOrder.setId(initOrder.getId());
        newOrder.setItemName(itemName);


        Order persistedOrder = orderService.create(newOrder);
        return new ResponseEntity<>(persistedOrder, HttpStatus.CREATED);
    }
    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @PutMapping("/updateOrder")
    public ResponseEntity<Order> updateUser(@RequestBody Order order){
        Order newOrder = orderService.update(order);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }
}
