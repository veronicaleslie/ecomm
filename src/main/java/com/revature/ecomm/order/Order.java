package com.revature.ecomm.order;

import com.revature.ecomm.Merch.Merch;
import com.revature.ecomm.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    private int id;
    @Column(name = "order_date")
    private String orderDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Merch", referencedColumnName = "item_name")
    private Merch itemName;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user", referencedColumnName = "username")
    private User username;
    @Column(name = "color")
    private String color;
}
