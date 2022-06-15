package com.System.PharmacyManagement.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class InvoiceMethod {

    private int num;
    private String drugName;
    private int price;
    private long quantity;
    private long total;

    public InvoiceMethod(int num, String drugName, int price, long quantity, long total) {
        this.num = num;
        this.drugName = drugName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }
}
