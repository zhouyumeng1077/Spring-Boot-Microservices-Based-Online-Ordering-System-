package com.imooc.sell.controller;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value =  "size",defaultValue = "10") Integer size,
                             Map<String,Object> map) {
        PageRequest request = new PageRequest(page - 1,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOpage",orderDTOPage);
        return new ModelAndView("order/list",map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                                Map<String,Object>  map) {

        try {
            OrderDTO orderDTO = orderService.findone(orderId);
            orderService.cancel(orderDTO);

        }catch (SellException e) {
            log.error("cannot find order{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String,Object>  map) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findone(orderId);
            orderService.cancel(orderDTO);
        }catch (SellException e) {
            log.error("cannot find order{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/detail");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.SUCCESS.getMessage());
        map.put("url","/sell/seller/order/detail");
        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }

    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String,Object>  map) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findone(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e) {
            log.error("cannot find order{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/finish");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.SUCCESS.getMessage());
        map.put("url","/sell/seller/order/finish");
        map.put("orderDTO",orderDTO);
        return new ModelAndView("common/success",map);
    }

}
