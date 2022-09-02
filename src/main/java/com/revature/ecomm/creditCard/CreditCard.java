package com.revature.ecomm.creditCard;


import com.revature.ecomm.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "credit_card")

public class CreditCard {
    @Id
    @Column(name = "cc_number", nullable = false)
    private String ccNumber;
    @Column (name = "cvv", nullable = false)
    private int cvv;
    @Column(name = "cc_name", nullable = false)
    private String ccName;
    @Column(name = "exp_date", nullable = false)
    private String expDate;
    @Column (name = "balance", nullable = false)
    private double balance;
    @ManyToOne(optional = false)
    @JoinColumn(name = "User", referencedColumnName = "username")
    private User username;

    public CreditCard(int i, int cvv, String bob, String expDate, int balance, User ex) {
    }
}
