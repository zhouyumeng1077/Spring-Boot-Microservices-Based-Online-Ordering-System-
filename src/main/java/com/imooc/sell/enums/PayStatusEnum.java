package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

    WAIT(0,"waiting"),
    SUCCESS(1,"SUCCESS"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
