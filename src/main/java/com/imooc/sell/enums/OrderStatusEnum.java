package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0,"new order"),
    FINISH(1,"finished order"),
    CANCEL(2,"cancel order"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static OrderStatusEnum getOrderStatusEnum(Integer code) {
        for(OrderStatusEnum orderStatusEnum:OrderStatusEnum.values()) {
            if(orderStatusEnum.getCode().equals(code)) {
                return orderStatusEnum;
            }
        }
        return null;
    }
}
