package com.order.order.service;

import com.order.order.model.OrderDTO;
import com.order.order.model.OrderEntity;
//import com.pachimari.user.UserDTO;

import java.util.List;

public interface OrderService {
    OrderDTO addOrder(OrderDTO order);
    List<OrderDTO> getOrders();
    List<OrderDTO> getUserOrders(String userDTO);
    OrderDTO getIdOrder(String id);
    void calculateAmountOrder(OrderDTO orderDTO) throws Exception;
}