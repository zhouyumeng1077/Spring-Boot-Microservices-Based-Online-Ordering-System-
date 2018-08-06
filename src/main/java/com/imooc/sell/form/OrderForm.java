package com.imooc.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "buyer name")
    private String name;

    @NotEmpty(message = "phone number")
    private String phone;

    @NotEmpty(message = "address")
    private String address;

    @NotEmpty(message = "openid")
    private String openid;

    @NotEmpty(message = "shopping cart")
    private  String items;
}
