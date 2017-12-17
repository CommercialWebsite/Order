package com.order.order.controller;

import com.order.order.exception.InvalidException;
import com.order.order.model.OrderDTO;
import com.order.order.model.OrderEntity;
import com.order.order.service.OrderServiceImpl;
//import com.pachimari.user.User;
//import com.pachimari.user.UserDTO;
//import com.pachimari.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private String userService;

    @GetMapping()
    public List<OrderDTO> getOrdersList() {
        return orderService.getOrders();
    }

    @GetMapping("/users/{id}")
    public List<OrderDTO> getOrdersListByLogin(@PathVariable("id") String login){
        String userDTO = login;

        return orderService.getUserOrders(userDTO);
    }

    @GetMapping("/id/{id}")
    public OrderDTO getOrdersListById(@PathVariable("id") String id){
        return orderService.getIdOrder(id);
    }

    @PostMapping()
    @ResponseStatus(CREATED)
    public OrderDTO createOrder(@RequestBody @Valid OrderDTO orderDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }

        return orderService.addOrder(orderDTO);
    }
}