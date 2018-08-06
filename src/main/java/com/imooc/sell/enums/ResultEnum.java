package com.imooc.sell.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"success"),
    PARAMETER_ERROR(1,"parameter error"),
    PRODUCT_NOT_EXSIT(10 , "not exit"),
    PRODUCT_STOCK_ERROR(11 , "not enough"),
    ORDER_NOT_EXIST(12 , "not exist"),
    ORDERDETAIL_NOT_EXIST(12 , "error"),
    ORDER_STATUS_ERROR(13 , "order status error"),
    ORDER_UPDATE_FAIL(14 , "order update fail"),
    ORDER_DETAIL_EMPTY(15 , "order update fail"),
    PAY_STATUS_ERROR(16 , "pay status error"),
    CART_EMPTY(18 , "pay status error"),
    ORDER_OWNER_ERROR(19 , "invalid id"),


    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
