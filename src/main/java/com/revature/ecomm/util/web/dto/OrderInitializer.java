package com.revature.ecomm.util.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInitializer {
    private int id;
    private String color;
    private String orderDate;
    private String itemName;
}
