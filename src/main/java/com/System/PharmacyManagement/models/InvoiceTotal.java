package com.System.PharmacyManagement.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class InvoiceTotal {

    private int num;
    private long total_quantity;
    private long total_price;


    public InvoiceTotal(int num, long total_quantity, long total_price) {
        this.num = num;
        this.total_quantity = total_quantity;
        this.total_price = total_price;
    }
}
