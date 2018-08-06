package com.imooc.sell.dataobject;

import javax.persistence.Id;

public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
