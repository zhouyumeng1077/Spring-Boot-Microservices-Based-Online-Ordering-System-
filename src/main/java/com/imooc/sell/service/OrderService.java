package com.imooc.sell.service;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface OrderService {
    /**create order**/

    OrderDTO create(OrderDTO orderDTO);

    /**check single order**/
    OrderDTO findone(String orderId);

    /**check order list**/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**cancel order**/
    OrderDTO cancel(OrderDTO orderDTO);

    /**finish order**/
    OrderDTO finish(OrderDTO orderDTO);

    /**order payment**/
    OrderDTO paid(OrderDTO orderDTO);

    Page<OrderDTO> findList(Pageable pageable)
}
