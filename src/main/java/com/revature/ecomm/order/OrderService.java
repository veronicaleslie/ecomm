package com.revature.ecomm.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService {
    public OrderDao orderDao;
            @Autowired
    public OrderService(OrderDao orderDao){
                this.orderDao = orderDao;
            }
            public Order create(Order newOrder){
                Order persistedOrder = orderDao.save(newOrder);
            return persistedOrder;
            }
            public Order update(Order updatedOrder){
                orderDao.save(updatedOrder);
                return updatedOrder;
            }
     public boolean validateInput(Order order){
                if (order == null) return false;
                if (order.getOrderDate() == null || order.getOrderDate().trim().equals(""))  return false;
                if (order.getUsername() == null) return false;
                if (order.getItemName() == null) return false;
                if (order.getId() <0) return false;
                return order.getColor() != null || order.getColor() == null;

     }
}
