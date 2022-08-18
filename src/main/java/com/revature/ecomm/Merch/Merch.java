package com.revature.ecomm.Merch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Merch {
    private String id;
    @Id
    @Column(name = "item_name", nullable = false)
    private String itemName;


    @Column(name = "item_cost")
    private int cost;
    private int netWeight;
    private String dimensions;
    private boolean isFurniture;
}
